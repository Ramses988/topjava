package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.web.meal.MealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management
//        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
//
//            MealRestController mealRestController = appCtx.getBean(MealRestController.class);
//            mealRestController.getAll().forEach(System.out::println);
//
//            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
//            adminUserController.create(new User(null, "Sergis", "user2@mail.ru", "password", Role.ROLE_USER));
//            adminUserController.create(new User(null, "Myke", "user1@mail.ru", "password", Role.ROLE_USER));
//            adminUserController.create(new User(null, "Admin", "email@mail.ru", "password", Role.ROLE_ADMIN));
//
//            System.out.println();
//            adminUserController.getAll().forEach(System.out::println);
//        }
    }
}
