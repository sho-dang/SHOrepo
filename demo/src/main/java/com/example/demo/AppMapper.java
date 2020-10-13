package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppMapper {
    @Select("SELECT * FROM datelist WHERE dateId = #{dateId}")
       DateList selectData (String dateId);

    @Select("SELECT * FROM datelist")
       List<DateList> datelist();

    @Insert("INSERT INTO datelist (dateId,dateName,year,month,day) VALUES(#{dateId}, #{dateName},#{year},#{month},#{day})")
       void create(DateList datelist);

    @Delete("DELETE FROM datelist WHERE dateId = #{dateId}")
       void delete(String dateId);
    //@Select("select year month day from datelist")
}
