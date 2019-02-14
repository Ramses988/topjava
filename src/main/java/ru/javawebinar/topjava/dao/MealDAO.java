package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDAO {

    private static AtomicInteger countId = new AtomicInteger(7);

    public List<MealTo> getAllMeals() {
        return MealsUtil.getMealsList();
    }

    public void deleteId(int id) {
        MealsUtil.meals.remove(getMeal(id));
    }

    public void addMeal(Meal meal) {
        meal.setId(countId.getAndIncrement());
        MealsUtil.meals.add(meal);
    }

    public void updateMeal(Meal meal) {
        int index = MealsUtil.meals.indexOf(meal);
        MealsUtil.meals.set(index, meal);
    }

    public Meal getMeal(int id) {
        for (Meal m : MealsUtil.meals) {
            if (m.getId() == id)
                return m;
        }
        return null;
    }
}
