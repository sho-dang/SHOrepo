package com.example.demo.ControllerTest;

import com.example.demo.Controller.AppController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppControllerTest {

    private MockMvc mockMvc;

    @Autowired
    AppController target;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
     }
     @Test
     public void HTTPステータスコードとビューの指定が正しいかのテスト()throws Exception{
          mockMvc.perform(get("/"))
          .andExpect(status().isOk())                         //ステータスコードはOKか
          .andExpect(view().name("index"))                    //指定のビューを返すか
          .andExpect(forwardedUrlTemplate("index"));          //遷移先URLの検証
     }
     @Test
     public void 属性が合っているかのテスト()throws Exception{
          
         mockMvc.perform(post("/"));
     }

}
