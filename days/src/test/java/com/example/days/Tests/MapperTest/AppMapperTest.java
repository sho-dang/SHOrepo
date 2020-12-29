package com.example.days.Tests.MapperTest;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.NameList.NameList;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
//import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@MybatisTest
//@TestPropertySource(properties = "classpath:test.properties")
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
    public void 指定したIDを元にshiftテーブルから名前を取得する()throws Exception{
        String inputId = "SA";
        String matcher = "伊藤A子";
        String converted = appMapper.convertName(inputId);
        assertThat(converted, is(matcher));
    }
    @Test
    public void 指定した名前を元にshiftテーブルからIDを取得する()throws Exception{
        String inputName = "伊藤A子";
        String matcher = "SA";
        String converted = appMapper.convertId(inputName);
        assertThat(converted, is(matcher));
    }
    @Test
    public void scheduleテーブルのデータを全て取得できる()throws Exception{
        List<DayList> days = appMapper.days();
        int matcher = 30 ;
        assertThat(days.size(), is(matcher));
    }
    @Test
    public void scheduleテーブルから指定した日付のデータを全て取得できる()throws Exception{
        int date = 30 ;
        String matcherWorkId = "0000";
        String matcherVacationId = "1XXXXXX2XXXXXX3XXXXXX";
        DayList dayList = appMapper.selectDayList(date);

        assertThat(dayList.getDate(), is(date));
        assertThat(dayList.getWorkId(), is(matcherWorkId));
        assertThat(dayList.getVacationCode(), is(matcherVacationId));
    }
    @Test
    public void scheduleテーブルで指定したdateのworkIdデータを取得()throws Exception{
        String matchWorkId = "0000" ;
        int date = 1 ;
        String workId = appMapper.matchWorkId(date);
        assertThat(workId, is(matchWorkId));
    }
    @Test
    public void scheduleテーブルで指定したdateのvacationCodeデータを取得()throws Exception{
        String matchVacationCode = "1XXXXXX2XXXXXX3XXXXXX" ;
        int date = 30 ;
        String vacationCode = appMapper.matchVacationCode(date);
        assertThat(vacationCode, is(matchVacationCode));
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
        String beforeWorkId = appMapper.matchWorkId(date);
        String workId = "3421";
        appMapper.updateWorkId(workId, date);
        String updatedWorkId = appMapper.matchWorkId(date);
        assertThat(updatedWorkId, is(workId));

        //Return WorkId
        appMapper.updateWorkId(beforeWorkId, date);
    }
    @Test
    public void scheduleテーブルで指定したdateのvacationCodeカラムを更新する()throws Exception{
        int date = 30 ;
        String beforeVacationCode = appMapper.matchVacationCode(date);
        String vacationCode = "1SAXXXX2SEXXXX3SIXXXX";
        appMapper.updateVacationCode(vacationCode, date);
        String updatedVacationCode = appMapper.matchVacationCode(date);
        assertThat(updatedVacationCode, is(vacationCode));

        //Return WorkId
        appMapper.updateVacationCode(beforeVacationCode,date);
    }
    @Test
    public void shiftテーブルに登録されている名前を削除できる(){
        String id = "TT";
        String name = "test";
        String shift = "シフト4";
        appMapper.insertName(id, name, shift);
        assertThat(appMapper.listAll().size(),is(17));

        appMapper.deleteName(id);
        assertThat(appMapper.listAll().size(),is(16));

    }
}
