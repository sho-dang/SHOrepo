package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppMapper {
    @Select("select year from datelist where dateID = #{dateID}")
       int year (@Param("dateID")String id);
}
