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
    List<NameList> listAll(); //test済み
    
    @Select("SELECT * FROM shift WHERE shiftName = #{shift} ORDER BY id ASC")
    List<NameList> listOne(String shift); //test済み

    @Select("SELECT nameList FROM shift WHERE id = #{id}")
    String convertName(String id); //test済み

    @Select("SELECT id FROM shift WHERE nameList = #{nameList}")
    String convertId(String nameList); //test済み

    @Select("SELECT * FROM schedule ORDER BY date ASC")
    List<DayList> days(); //test済み

    @Select("SELECT * FROM schedule WHERE date = #{date}")
    DayList selectDayList(int date); //test済み

    @Select("SELECT workId FROM schedule WHERE date = #{date}")
    String matchWorkId(int date); //test済み

    @Select("SELECT vacationCode FROM schedule WHERE date = #{date}")
    String matchVacationCode(int date); //test済み

    @Select("SELECT number FROM shiftpattern WHERE patternId = #{patternId}")
    int number(String patternId); //test済み

    @Select("SELECT shiftPattern FROM shiftpattern WHERE number = #{number}")
    String shiftPattern(int number); //test済み

    @Update("update schedule set workId=#{workId} where date = #{date}")
    void updateWorkId(@Param("workId") String workId,@Param("date")int date); //test済み

    @Transactional
    @Update("update schedule set vacationCode=#{vacationCode} where date = #{date}")
    void updateVacationCode(@Param("vacationCode") String vacationCode,@Param("date")int date); //test済み
    
}
