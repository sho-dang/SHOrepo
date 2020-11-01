package com.example.demo.MapperTest;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMapperTest {
    @Autowired
    AppMapper appMapper;


    @Test
    public void データを全件取得()throws Exception{
       List<DateList> li = appMapper.datelist();
       assertThat(li.size(),is(4));
    }

    @Test
    public void 選択したIDを元にレコードを取得(){
        DateList dateList = appMapper.selectData("3Y");
        assertThat(dateList.getDateId(),is("3Y"));
        assertThat(dateList.getDateName(),is("3年後"));
        assertThat(dateList.getYear(),is(3));
        assertThat(dateList.getMonth(),is(0));
        assertThat(dateList.getDay(),is(0));
    }

    @Test
    public void 選択したIDのレコードを変更(){
        DateList dateList = createDateList("3Y","30年後",30,1,1);
        appMapper.update(dateList);
        
        assertThat(dateList.getDateId(),is("3Y"));
        assertThat(dateList.getDateName(),is("30年後"));
        assertThat(dateList.getYear(),is(30));
        assertThat(dateList.getMonth(),is(1));
        assertThat(dateList.getDay(),is(1));

        DateList returnDateList = createDateList("3Y","3年後",3,0,0);
        appMapper.update(returnDateList);
    }   
    
    //コンストラクタを使用、DateListではコンストラクタ定義していないが
    //特例によりデフォルトコンストラクタが存在している、オーバーロード
    public DateList createDateList(
                      String dateId,
                      String dateName,
                      int year,
                      int month,
                      int day){
          DateList dateList = new DateList();
          dateList.setDateId(dateId);
          dateList.setDateName(dateName);
          dateList.setYear(year);
          dateList.setMonth(month);
          dateList.setDay(day);
          return dateList;
    }
}
