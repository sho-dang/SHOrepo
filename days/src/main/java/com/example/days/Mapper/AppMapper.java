package com.example.days.Mapper;

import java.util.List;

import com.example.days.domain.DayList;
import com.example.days.domain.DaySplit;
import com.example.days.domain.NameList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppMapper {
    @Select("SELECT * FROM shift ORDER BY id ASC")
    List<NameList> list();
    
    @Select("SELECT * FROM shift where shiftName = #{shift} ORDER BY id ASC")
    List<NameList> listOne(String shift);

    @Select("SELECT * FROM schedule ORDER BY date ASC")
    List<DayList> days();

    /*
    @Select("SELECT workId FROM schedule ORDER BY date ASC")
    DaySplit workCode();
    */
}
