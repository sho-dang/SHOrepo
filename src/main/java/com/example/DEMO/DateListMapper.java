package com.example.DEMO;

//import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

	@Mapper
	public interface DateListMapper {
		@Select("select id,datename,ymd from datelist where id = #{id}")
	   	    List<DateList> selectAll(@Param("id") int id);
		//@Select("select count(id) from dateList = #{count}")
			//int count();



    }
	/*
	List<DateList> selectAll();
    DateList select(int id);
    int insert (DateList dateList);
    int update (DateList dateList);
    int delete (int id);
	*/