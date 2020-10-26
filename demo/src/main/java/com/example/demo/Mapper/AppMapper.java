package com.example.demo.Mapper;

import java.util.List;

import com.example.demo.domain.DateList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("mapper")
@Mapper
public interface AppMapper {
    @Select("SELECT * FROM datelist WHERE dateId = #{dateId}")
       DateList selectData (String dateId);

    @Select("SELECT * FROM datelist")
       List<DateList> datelist();

    @Update("UPDATE datelist SET dateName=#{dateName},year=#{year},month=#{month},day=#{day} WHERE dateId = #{dateId}")
       void update(DateList dateList);

    @Insert("INSERT INTO datelist (dateId,dateName,year,month,day) VALUES(#{dateId}, #{dateName},#{year},#{month},#{day})")
       void create(DateList datelist);

    @Delete("DELETE FROM datelist WHERE dateId = #{dateId}")
       void delete(String dateId);

}
