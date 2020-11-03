package com.example.demo.ServiceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.example.demo.Mapper.AppMapper;
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
    public void データを全件取得できているかを確認するテスト()throws Exception{
         List<DateList> li = ser.dateLists();
         assertThat(li.size(),is(4));
    }
   @Test
   public void 選択したIDを元にレコードを取得できるかのテスト(){
        DateList dateList = ser.select("5Y");
        assertThat(dateList.getDateId(), is("5Y"));
        assertThat(dateList.getDateName(), is("5年後"));
        assertThat(dateList.getYear(), is(5));
        assertThat(dateList.getMonth(), is(0));
        assertThat(dateList.getDay(), is(0));
   }
   @Test
   public void 入力した日付を計算して出力出来ているかの確認(){
       DateList dateList = createDateList("test","All+1",1,1,1);
       String calced = ser.calced("20000101", dateList);
       assertThat(calced,is("20010202"));
   }

   //デフォルトコンストラクタ、オーバーロード
   public DateList createDateList(String dateId,String dateName,int year,int month,int day){
        DateList dateList = new DateList();
        dateList.setDateId(dateId);
        dateList.setDateName(dateName);
        dateList.setYear(year);
        dateList.setMonth(month);
        dateList.setDay(day);
        return dateList;
   }
}
