package com.example.DEMO;
//import java.util.List;

import java.util.List;

//import com.example.DEMO.DateList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.;
//import org.springframework.context.annotation.Bean;
//import com.example.DEMO.UserInfo;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Select;

	@Mapper
	public interface DateListMapper {
		@Select("select * from dateList where id = #{id}")
	   	    List<DateList> findByList(@Param("id") int id);
		//@Select("select count(id) from dateList = #{id}")
			//int count (@Param("id") int count);
	}

	/*List<DateList> selectAll();
    DateList select(int id);
    int insert (DateList dateList);
    int update (DateList dateList);
    int delete (int id);
	*/