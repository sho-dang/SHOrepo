package com.example.days.MapperTest;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.NameList.NameList;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@PropertySource("classpath:/src/test/test.properties")
public class AppMapperTest {
    @Autowired
    AppMapper appMapper;

    @Test
    public void shiftテーブルのデータを全て取得できる()throws Exception{
        List<NameList> listAll = appMapper.listAll();
        int matcher = 16;
        assertThat(listAll.size(),is(matcher));
    }
    
    @Test
    public void shiftテーブルで指定したshiftNameのmemberリストを全て取得できる()throws Exception{
        String shiftName = "シフト1";
        int matcher = 4 ;
        List<NameList> listOne = appMapper.listOne(shiftName);
        assertThat(listOne.size(), is(matcher));
    }

    @Test
    public void scheduleテーブルのデータを全て取得できる()throws Exception{
        List<DayList> days = appMapper.days();
        int matcher = 30 ;
        assertThat(days.size(), is(matcher));
    }

    @Test
    public void scheduleテーブルで指定したdateのworkIdデータを取得()throws Exception{
        String matchWorkId = "3421" ;
        int date = 1 ;
        String workId = appMapper.matchWorkId(date);
        assertThat(workId, is(matchWorkId));
    }

    @Test
    public void shiftpatternテーブルで指定したpatternIdのnumberを取得()throws Exception{
        int matchNumber = 1 ;
        String matchPatternId = "44222" ; 
        int patternId = appMapper.number(matchPatternId);
        assertThat(patternId, is(matchNumber));
    }

    @Test
    public void shiftpatternテーブルで指定したnumberのshiftPatternを取得()throws Exception{
        String matchShiftPattern = "4321" ;
        int number = 2 ;
        String shiftPattern = appMapper.shiftPattern(number);
        assertThat(shiftPattern, is(matchShiftPattern));
    }

    @Test
    public void scheduleテーブルで指定したdateのworkIdカラムを更新する()throws Exception{
        int date = 1 ;
        String workId = "3421";
        appMapper.updateWorkId(workId, date);
        String updatedWorkId = appMapper.matchWorkId(date);
        assertThat(updatedWorkId, is(workId));
    }

}
