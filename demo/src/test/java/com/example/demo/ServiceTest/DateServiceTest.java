package com.example.demo.ServiceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
         assertThat(li.size(),is(4));
    }
   @Test
   public void 選択したIDを元にレコードを取得できる(){
        DateList dateList = ser.select("5Y");
        assertThat(dateList.getDateId(), is("5Y"));
        assertThat(dateList.getDateName(), is("5年後"));
        assertThat(dateList.getYear(), is(5));
        assertThat(dateList.getMonth(), is(0));
        assertThat(dateList.getDay(), is(0));
   }
}
