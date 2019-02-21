package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;
import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public List<MealTo> getAll() {
        log.info("Call getAll Meal");
        return MealsUtil.getWithExcess(service.getAll(authUserId()), DEFAULT_CALORIES_PER_DAY);
    }

    public List<MealTo> getAllFilter(String startDate, String endDate, String startTime, String endTime) {
        if ((startDate != null && endDate != null) && (startTime != null && endTime != null)) {
            return MealsUtil.getFilteredWithExcess1(service.getAll(authUserId()), DEFAULT_CALORIES_PER_DAY, LocalDateTime.parse(startDate+"T"+startTime),
                    LocalDateTime.parse(endDate+"T"+endTime));
        } else if (startDate != null && endDate != null) {
            return MealsUtil.getFilteredWithExcess2(service.getAll(authUserId()), DEFAULT_CALORIES_PER_DAY, LocalDate.parse(startDate.replace("T", "")),
                    LocalDate.parse(endDate.replace("T", "")));
        } else{
            return MealsUtil.getFilteredWithExcess(service.getAll(authUserId()), DEFAULT_CALORIES_PER_DAY, LocalTime.parse(startTime.replace("T", "")),
                    LocalTime.parse(endTime.replace("T", "")));
        }
    }

    public void create(Meal meal) {
        service.create(meal);
    }

    public void update(Meal meal) {
        service.update(meal);
    }

    public Meal get(int id) {
        return service.get(id, authUserId());
    }

    public void delete(int id) {
        service.delete(id, authUserId());
    }
}