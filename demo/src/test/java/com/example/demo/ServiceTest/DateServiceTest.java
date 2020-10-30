package com.example.demo.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.Service.DateService;
import com.example.demo.domain.DateList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateServiceTest {
    @Autowired
    DateService ser;

    

    @Test
    public void 全件取得()throws Exception{
      // DateService ser = new DateService();
         List<DateList> li = ser.dateLists();
         assertEquals(li.size(),4);
    }

}
