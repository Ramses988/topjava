package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Get meals list");
        List<MealTo> meals = MealsUtil.getMealsList();
        req.setAttribute("mealsList", meals);
        log.info("Forward meals list");
        req.getRequestDispatcher("meals.jsp").forward(req, resp);
    }
}
