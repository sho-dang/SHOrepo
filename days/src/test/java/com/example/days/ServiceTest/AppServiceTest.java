package com.example.days.ServiceTest;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.DayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceTest {
    @Autowired
    AppService service;

    @Test
    public void 取得したDayListの件数が一致すること()throws Exception{
        List<DayList> dayTest = service.days();
        int monthDays = 30;
        assertThat(dayTest.size(),is(monthDays));
    }
    @Test
    public void 取得したDayListの件数が違う場合にエラーとなること()throws Exception{
        List<DayList> dayTest = service.days();
        int monthDays = 100;
        assertThat(dayTest.size(),not(monthDays));
    }

}
