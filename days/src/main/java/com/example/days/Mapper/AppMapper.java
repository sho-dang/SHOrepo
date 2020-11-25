package com.example.days.Mapper;

import java.util.List;

import com.example.days.domain.DayList;
import com.example.days.domain.DaySplit;
import com.example.days.domain.NameList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AppMapper {
    @Select("SELECT * FROM shift ORDER BY id ASC")
    List<NameList> listAll();
    
    @Select("SELECT * FROM shift WHERE shiftName = #{shift} ORDER BY id ASC")
    NameList listOne(String shift);

    @Select("SELECT * FROM schedule ORDER BY date ASC")
    List<DayList> days();
    
    @Update("UPDATE schedule SET workId=#{workId} WHERE date = #{date}")
    void updateWorkId();
    
}
