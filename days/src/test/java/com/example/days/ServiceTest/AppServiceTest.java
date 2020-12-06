package com.example.days.ServiceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.NameList.NameList;

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
    public void ーnameListAllメソッドーnameListを全件取得できていること()throws Exception{
        List<NameList> nameList = service.nameListAll();
        int matcher = 16 ;
        assertThat(nameList.size(), is(matcher));
    }
    @Test
    public void ーnameListAllメソッドーnameListの取得件数が違う場合にエラーになること()throws Exception{
        List<NameList> nameList = service.nameListAll();
        int matcher = 50 ;
        assertThat(nameList.size(), not(matcher));
    }
    @Test
    public void ーlistOneメソッドー選択したshiftNameのレコード件数が一致すること()throws Exception{
        List<NameList> listOne = service.listOne("シフト1");
        int matcher = 4;
        assertThat( listOne.size(), is(matcher));
    }
    @Test
    public void ーlistOneメソッドー選択したshiftNameのレコード件数が違う場合にエラーになること()throws Exception{
        List<NameList> listOne = service.listOne("シフト1");
        int matcher = 10;
        assertThat( listOne.size(), not(matcher));
    }
    @Test //現在はシフト
    public void ーshiftListメソッドーインスタンス作成後新しいNameListを取得できていること()throws Exception{
        List<NameList> listTest = service.nameListAll();
        List<NameList> resultList = service.shiftList(listTest);
        int matcher = 16 ;
        assertThat(resultList.size(), is(matcher));
    }
    @Test
    public void ーshiftListメソッドー選したdateと一致するworkIdを取得できていること()throws Exception{
        int selectDay = 1 ;
        String workId = service.matchWorkId(selectDay);
        String matcher = "";
        assertThat(workId, is(matcher));
    }
    @Test
    public void ーdaysメソッドー取得したDayListの日付件数が一致すること()throws Exception{
        List<DayList> dayTest = service.days();
        int monthDays = 30;
        assertThat(dayTest.size(),is(monthDays));
    }
    @Test
    public void ーdaysメソッドー取得したDayListの日付件数が違う場合にエラーとなること()throws Exception{
        List<DayList> dayTest = service.days();
        int monthDays = 100;
        assertThat(dayTest.size(),not(monthDays));
    }
    
    @Test
    public void ーmatchWorkIdメソッドー選択したdateと一致するworkIdを取得できていること()throws Exception{
        int selectDay = 1 ;
        String workId = service.matchWorkId(selectDay);
        String matcher = "";
        assertThat(workId, is(matcher));
    }
    @Test
    public void ーmatchWorkIdメソッドー取得したworkIdが一致していない場合にエラーとなること()throws Exception{

    }
    @Test
    public void ーshiftPatternメソッドー()throws Exception{

    }
    @Test
    public void shiftPatternメソッドー()throws Exception{

    }
    @Test
    public void updateMethodメソッドー()throws Exception{

    }
    @Test
    public void ーupdateMethodメソッドー()throws Exception{

    }
}
