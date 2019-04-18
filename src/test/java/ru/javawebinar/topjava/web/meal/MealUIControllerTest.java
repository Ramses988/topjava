package ru.javawebinar.topjava.web.meal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MealUIControllerTest extends AbstractControllerTest {

    @Autowired
    private MealService service;

    @Test
    void testCreate() throws Exception {
        mockMvc.perform(post("/ajax/meal/")
        .param("id", "")
        .param("dateTime", "2019-04-16T12:00")
        .param("description", "Завтрак")
        .param("calories", "1000"))
        .andExpect(status().isNoContent());
    }
}