package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppMapper {
    @Select("select year from datelist where dateId = #{dateId}")
       int year (@Param("dateId")String id);
    @Select("select * from datelist")
       List<DateList> datelist();
}
