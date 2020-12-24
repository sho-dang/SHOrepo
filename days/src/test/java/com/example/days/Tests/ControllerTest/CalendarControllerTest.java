package com.example.days.Tests.ControllerTest;

import com.example.days.Controller.CalendarController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarControllerTest {
    //@InjectMocks
    //private DaysController daysController;
    private MockMvc mockMvc;

    @Autowired
    CalendarController target;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    @Test
    public void カレンダー画面のステータスコードが200であること()throws Exception{
        mockMvc.perform(get("/list"))
        .andExpect(status().isOk())
        .andExpect(view().name("calendar"));
    }
    @Test
    public void カレンダー画面の休暇日登録後にリダイレクトされること()throws Exception{
        mockMvc.perform(post("/list").param("date","1"))
        .andExpect(redirectedUrl("/list"));
    }


}
