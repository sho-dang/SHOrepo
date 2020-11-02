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
    public void データを全件取得出来ているかを確認するテスト()throws Exception{
       List<DateList> li = appMapper.datelist();
       assertThat(li.size(),is(4));
    }

    @Test
    public void 選択したIDを元にレコードを取得出来ているかを確認するテスト(){
        DateList dateList = appMapper.selectData("3Y");
        assertThat(dateList.getDateId(),is("3Y"));
        assertThat(dateList.getDateName(),is("3年後"));
        assertThat(dateList.getYear(),is(3));
        assertThat(dateList.getMonth(),is(0));
        assertThat(dateList.getDay(),is(0));
    }

    @Test
    public void レコードを変更を確認するテスト(){
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

    @Test
    public void 新規登録したのち削除ができているかを確認するテスト(){
        DateList dateList =new DateList();
        dateList = createDateList("test","100年前",-100,-2,-2);
        appMapper.create(dateList);
        //登録完了
        
        List<DateList> list = appMapper.datelist();
        assertThat(list.size(),is(5));
        //件数増加確認

        appMapper.delete("test");
        //削除実行

        List<DateList> lists = appMapper.datelist();
        assertThat(lists.size(),is(4));
        //削除後、件数確認
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
