package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;

import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;

import java.util.List;

@Controller
public class MealRestController extends AbstractMealController {

    public List<MealTo> getAll() {
        return super.getAll(authUserId());
    }

    public Meal get(int id) {
        return super.get(id, authUserId());
    }

    public void create(Meal meal) {
        super.create(meal);
    }

    public void update(Meal meal) {
        super.update(meal);
    }

    public void delete(int id) {
        super.delete(id, authUserId());
    }
}