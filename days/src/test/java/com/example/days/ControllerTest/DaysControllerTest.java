package com.example.days.ControllerTest;

import com.example.days.Controller.DaysController;
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
public class DaysControllerTest {

    private MockMvc mockMvc;

    @Autowired
    DaysController target;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    @Test
    public void スタート画面のステータスコードが200であること()throws Exception{
        mockMvc.perform(get("/"))
        .andExpect(status().isOk());
    }

}