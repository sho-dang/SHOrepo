package com.example.days.Mapper;

import java.util.List;

import com.example.days.domain.Day.DayList;
import com.example.days.domain.NameList.NameList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface AppMapper {
    @Select("SELECT * FROM shift ORDER BY id ASC")
    List<NameList> listAll();
    
    @Select("SELECT * FROM shift WHERE shiftName = #{shift} ORDER BY id ASC")
    List<NameList> listOne(String shift);

    @Select("SELECT nameList FROM shift WHERE id = #{id}")
    String convertName(String id);

    @Select("SELECT id FROM shift WHERE nameList = #{nameList}")
    String convertId(String nameList);

    @Select("SELECT * FROM schedule ORDER BY date ASC")
    List<DayList> days();

    @Select("SELECT * FROM schedule WHERE date = #{date}")
    DayList selectDayList(int date); 

    @Select("SELECT workId FROM schedule WHERE date = #{date}")
    String matchWorkId(int date);

    @Select("SELECT number FROM shiftpattern WHERE patternId = #{patternId}")
    int number(String patternId);

    @Select("SELECT shiftPattern FROM shiftpattern WHERE number = #{number}")
    String shiftPattern(int number);

    @Update("update schedule set workId=#{workId} where date = #{date}")
    void updateWorkId(@Param("workId") String workId,@Param("date")int date);

    @Transactional
    @Update("update schedule set vacationCode=#{vacationCode} where date = #{date}")
    void updateVacationCode(@Param("vacationCode") String vacationCode,@Param("date")int date);
    
}
