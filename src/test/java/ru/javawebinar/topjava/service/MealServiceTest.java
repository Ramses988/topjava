package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

@RunWith(SpringRunner.class)
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(100, 100000);
        assertMatch(meal, MEAL1);
    }

    @Test(expected = NotFoundException.class)
    public void getOther() {
        service.get(100, 100001);
    }

    @Test
    public void delete() {
        Meal meal = service.create(new Meal(LocalDateTime.now(), "Ужин", 500), 100001);
        service.delete(meal.getId(), 100001);
        assertMatch(service.getAll(100001), MEAL2, MEAL3);
    }

    @Test
    public void update() {
        service.update(new Meal(103, LocalDateTime.of(2019, Month.FEBRUARY, 23, 19, 00),
                "Ужин", 700), 100000);
        Meal meal = service.get(103, 100000);
        assertMatch(meal, MEAL4);
    }

    @Test(expected = NotFoundException.class)
    public void deleteOther() {
        service.delete(100, 100001);
    }

    @Test
    public void getAll() {
        List<Meal> lists = service.getAll(100001);
        assertMatch(lists, MEAL2, MEAL3);
    }
}
