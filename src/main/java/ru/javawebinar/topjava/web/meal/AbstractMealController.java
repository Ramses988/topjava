package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

import java.util.List;

public abstract class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public List<MealTo> getAll(int userId) {
        log.info("Call getAll Meal");
        return MealsUtil.getWithExcess(service.getAll(userId), DEFAULT_CALORIES_PER_DAY);
    }

    public void create(Meal meal) {
        service.create(meal);
    }

    public void update(Meal meal) {
        service.update(meal);
    }

    public Meal get(int id, int userId) {
        return service.get(id, userId);
    }

    public void delete(int id, int userId) {
        service.delete(id, userId);
    }
}
