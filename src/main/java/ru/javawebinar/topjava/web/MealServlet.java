package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);
    private MealDAO mealDAO;
    private DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public MealServlet() {
        this.mealDAO = new MealDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action != null) {
            if(action.equalsIgnoreCase("delete")) {
                mealDAO.deleteId(Integer.valueOf(req.getParameter("id")));
                resp.sendRedirect("meals");
            } else if (action.equalsIgnoreCase("edit")) {
                Meal meal = mealDAO.getMeal(Integer.valueOf(req.getParameter("id")));
                req.setAttribute("meal", meal);
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            } else if (action.equalsIgnoreCase("add")) {
                Meal meal = new Meal(0, null, null, 0);
                req.setAttribute("meal", meal);
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            }
        } else {
            getList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String date = req.getParameter("dateTime");
        LocalDateTime dateTime = LocalDateTime.parse(date, formater);
        String description = req.getParameter("description");
        int calories = Integer.valueOf(req.getParameter("calories"));

        Meal meal = new Meal(id, dateTime, description, calories);

        if (id > 0)
            mealDAO.updateMeal(meal);
        else
            mealDAO.addMeal(meal);

        resp.sendRedirect("meals");
    }

    private void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Get meals list");
        List<MealTo> meals = mealDAO.getAllMeals();
        req.setAttribute("mealsList", meals);
        log.info("Forward meals list");
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}