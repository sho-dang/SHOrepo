package com.example.DEMO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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
        @Update("update datelist set dateId=#{dateId},datename=#{dateName},ymd=#{ymd} where id = #{iddd}")
            void update(@Param("dateId")String dateId,
        		    @Param("dateName")String dateName,
        		    @Param("ymd")String ymd,
        		    @Param("iddd")int id);
        @Insert("insert into datelist (dateId,datename,ymd) value(#{dateId},#{dateName},#{ymd})")
        @Options(useGeneratedKeys=true)
            void create(@Param("dateId")String dateId,@Param("dateName")String dateName,@Param("ymd")String ymd);
        @Delete("delete from datelist where id = #{idddd}")
            void delete(@Param("idddd")int id);
    }

