package com.example.DEMO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

	@Mapper
	public interface DateListMapper {
		@Select("select * from datelist")
	   	    List<DateList> selectAll();
		@Select("select id from dateList")
			List<DateList> id();
		@Select("select ymd from dateList where id = #{id}")
		    String ymd(@Param("id")int id);
        @Update("update datelist set calc=#{data} where id = #{idd}")
            void updateCalc(@Param("data")String data,@Param("idd")int id);

    }
