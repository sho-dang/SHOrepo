package com.example.days.ServiceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
    @Test
    public void ーconvertNameメソッドー指定したIDの名前を取得できていること(){
        String nameId = "SA";
        String matcherName = "伊藤A子";
        String convertName = service.convertName(nameId);
        assertThat(convertName, is(matcherName));
    }
    @Test(expected = NullPointerException.class)
    public void ーconvertNameメソッドー指定したIDが存在しない場合にエラーとなること(){
        String nameId = "AA";
        String convertName = service.convertName(nameId);
        assertThat(convertName, is(null));
    }
    @Test
    public void ーconvertIdメソッドー指定した名前のIDを取得できていること(){
        String name = "伊藤A子";
        String matcherId = "SA";
        String convertId = service.convertId(name);
        assertThat(convertId, is(matcherId));
    }
    @Test(expected = NullPointerException.class)
    public void ーconvertIdメソッドー指定した名前が存在しない場合にエラーとなること(){
        String name = "飯田Z子";
        String convertId = service.convertId(name);
        assertThat(convertId, is(null));
    }
    @Test //シフト振り分け用メソッド未完成
    public void ーshiftListメソッドーインスタンス作成後新しいNameListを取得できていること()throws Exception{
        List<NameList> listTest = service.nameListAll();
        List<NameList> resultList = service.shiftList(listTest);
        int matcher = 16 ;
        assertThat(resultList.size(), is(matcher));
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
        String matcher = "3142";
        assertThat(workId, is(matcher));
    }
    @Test
    public void ーmatchWorkIdメソッドー存在しない日付を入力した場合にworkIDはNULLになりエラーとなること()throws Exception{
        int selectDay = 31 ;
        String workId = service.matchWorkId(selectDay);
        String matcher = null;
        assertThat(workId, is(matcher));
    }
    @Test
    public void ーshiftPatternメソッドー指定したnumberと一致するshiftPatternを取得できること()throws Exception{
        int number = 1 ;
        String shiftPattern = service.shiftPattern(number);
        String matcher = "4321";
        assertThat(shiftPattern, is(matcher)); 
    }
    @Test
    public void ーshiftPatternメソッドー存在しないnumberを入力した場合にshiftpatternはNULLになりエラーとなること()throws Exception{
        int number = 21 ;
        String shiftPattern = service.shiftPattern(number);
        String matcher = null;
        assertThat(shiftPattern, is(matcher)); 
    }
    @Test //未実装
    public void updateMethodメソッドー()throws Exception{

    }
    @Test //未実装
    public void ーupdateMethodメソッドー()throws Exception{

    }
}
