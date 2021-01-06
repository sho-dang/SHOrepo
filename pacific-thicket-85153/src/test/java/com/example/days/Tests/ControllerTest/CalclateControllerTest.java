package com.example.days.Tests.ControllerTest;

import com.example.days.Controller.CalclateController;

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
public class CalclateControllerTest {
    private MockMvc mockMvc;

    @Autowired
    CalclateController taeget;

    @Before
    public void sutUp(){
        mockMvc=MockMvcBuilders.standaloneSetup(taeget).build();
    }

    @Test
    public void 自動計算画面でステータスコードが200であること()throws Exception{
        mockMvc.perform(get("/calclate"))
        .andExpect(status().isOk())
        .andExpect(view().name("calclate.html"));
    }
    @Test
    public void 自動計算画面でformを入力して自動計算後にカレンダー画面に遷移すること()throws Exception{

        mockMvc.perform(post("/calclate")
        .param("inputDate","1")
        .param("inputCode","33334")
        )
        .andExpect(redirectedUrl("/calendar"));
    }
}
