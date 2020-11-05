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
   public void 入力した日付を計算して出力出来ているかの確認テスト(){
       DateList dateList = createDateList("test","All+1",1,1,1);
       String calced = ser.calced("20000101", dateList);
       assertThat(calced,is("20010202"));
   }

   @Test
   public void 選択したデータの更新テスト(){
        DateList dateList = createDateList("3Y","20年後",20,0,0);
        ser.update(dateList);

        assertThat(dateList.getDateId(),is("3Y"));
        assertThat(dateList.getDateName(),is("20年後"));
        assertThat(dateList.getYear(),is(20));
        assertThat(dateList.getMonth(),is(0));
        assertThat(dateList.getDay(),is(0));

        DateList returnDateList = createDateList("3Y","3年後",3,0,0);
        ser.update(returnDateList);

   }

   @Test 
   public void 新規作成と削除メソッドのテスト(){
        DateList dateList = createDateList("tester","All+3",3,3,3);
        ser.create(dateList);
        DateList select = ser.select("tester");
        assertThat(select.getDateId(),is("tester"));
        assertThat(select.getDateName(),is("All+3"));
        assertThat(select.getYear(),is(3));
        assertThat(select.getMonth(),is(3));
        assertThat(select.getDay(),is(3));

        List<DateList> dateLists = ser.dateLists();
        assertThat(dateLists.size(),is(5));

        ser.delete("tester");
        List<DateList> returnDateLists = ser.dateLists();
        assertThat(returnDateLists.size(),is(4));
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
