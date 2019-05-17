package ru.javawebinar.topjava.web.meal;

import io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.web.AbstractControllerTest;
import ru.javawebinar.topjava.web.json.JsonUtil;

import java.time.Month;

import static java.time.LocalDateTime.of;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.TestUtil.*;
import static ru.javawebinar.topjava.UserTestData.USER;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

class MealUIControllerTest extends AbstractControllerTest {

    private final String URL = "/ajax/profile/meals/";

    @Autowired
    private MealService service;

    @Test
    void testGet() throws Exception {
        mockMvc.perform(get(URL + MEAL1_ID)
                .with(userHttpBasic(USER)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertMatch(readFromJsonMvcResult(result, Meal.class), MEAL1));
    }

    @Test
    void testCreate() throws Exception {
//        ResultActions action = mockMvc.perform(post(URL)
//                .with(userHttpBasic(USER))
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("id", "null")
//                .param("dateTime", "2019-05-17T12:00")
//                .param("description", "Ужин")
//                .param("calories", "300"));


                mockMvc.perform(MockMvcRequestBuilderUtils.postForm(URL, new MealTo(100007, of(2017, Month.MAY, 17, 15, 0), "Обед", 300, false))
                .with(userHttpBasic(USER)));
    }
}
