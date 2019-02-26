package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTestData {

    public static final Meal MEAL1 = new Meal(100, LocalDateTime.of(2019, Month.FEBRUARY, 23, 10, 00), "Завтрак", 1000);
    public static final Meal MEAL2 = new Meal(101, LocalDateTime.of(2019, Month.FEBRUARY, 23, 10, 00), "Завтрак", 1000);
    public static final Meal MEAL3 = new Meal(102, LocalDateTime.of(2019, Month.FEBRUARY, 23, 13, 00), "Обед", 1000);
    public static final Meal MEAL4 = new Meal(103, LocalDateTime.of(2019, Month.FEBRUARY, 23, 19, 00), "Ужин", 700);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields().isEqualTo(expected);
    }
}