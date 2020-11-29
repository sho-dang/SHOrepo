package com.example.days.Mapper;

import java.util.List;

import com.example.days.domain.DayList;
import com.example.days.domain.NameList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AppMapper {
    @Select("SELECT * FROM shift ORDER BY id ASC")
    List<NameList> listAll();
    
    @Select("SELECT * FROM shift WHERE shiftName = #{shift} ORDER BY id ASC")
    List<NameList> listOne(String shift);

    @Select("SELECT * FROM schedule ORDER BY date ASC")
    List<DayList> days();

    @Select("SELECT workId FROM schedule WHERE date = #{date}")
    String matchWorkId(int date);

    @Select("SELECT number FROM shiftpattern WHERE patternId = #{patternId}")
    int number(String patternId);

    @Select("SELECT shiftPattern FROM shiftpattern WHERE number = #{number}")
    String shiftPattern(int number);
    
    //@Update("UPDATE schedule SET workId = #{workId} WHERE date = #{date}")
    @Update("update schedule set workId=#{workId} where date = #{date}")
    void updateWorkId(@Param("workId") String workId,@Param("date")int date);
    
}
