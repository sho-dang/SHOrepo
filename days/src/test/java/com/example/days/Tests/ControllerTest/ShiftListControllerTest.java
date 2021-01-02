package com.example.days.Tests.ControllerTest;

import com.example.days.Controller.ShiftListController;

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
public class ShiftListControllerTest {
    private MockMvc mockMvc;

    @Autowired
    ShiftListController target;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }
    @Test
    public void シフト画面のステータスコードが200であること()throws Exception{
        mockMvc.perform(get("/shift"))
        .andExpect(status().isOk())
        .andExpect(view().name("shift.html"));
    }
    @Test
    public void シフト画面で新規登録後にリダイレクトされること()throws Exception{
        mockMvc.perform(post("/shift").param("insert","insert")
        .param("id","XX")
        .param("nameList","ダミー")
        .param("shiftName","シフト1")
        )
        .andExpect(redirectedUrl("/shift"));
    }
    @Test
    public void シフト画面で名前削除後にリダイレクトされること()throws Exception{
        mockMvc.perform(post("/shift").param("delete","delete")
        .param("id","XX")
        .param("nameList","ダミー")
        .param("shiftName","シフト1")
        )
        .andExpect(redirectedUrl("/shift"));
    }
}
