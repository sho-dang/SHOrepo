package com.example.DEMO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

	@Mapper
	public interface DateListMapper {
		@Select("select * from datelist")                                        //indexデータすべて表示
	   	    List<DateList> selectAll();
		@Select("select dateId from datelist")                                   //dateIdをすべて表示
			List<DateList> id();
		@Select("select dateId from datelist")                                   //dateIdデータを配列化
		    String[] selectOne();
		@Select("select ymd from datelist where dateId = #{dateId}")             //指定したdateId行のymdを取得
		    String ymd(@Param("dateId")String dateId);

        @Update("update datelist set calc=#{data} where dateId = #{dateId}")     //計算した年月日を更新
            void updateCalc(
            		@Param("data")String data,
            		@Param("dateId")String dateId);


        @Update("update datelist set dateId=#{dateId},datename=#{dateName},ymd=#{ymd} where dateId = #{dateId}")
            void update(@Param("dateId")String id,                               //データすべて更新
        		        @Param("dateName")String dateName,
        		        @Param("ymd")String ymd,
        		        @Param("dateId")String dateId);
        @Insert("insert into datelist (dateId,datename,ymd) value(#{dateId},#{dateName},#{ymd})")
            void create(@Param("dateId")String dateId,                           //データ新規作成
            		    @Param("dateName")String dateName,
            		    @Param("ymd")String ymd);
        @Delete("delete from datelist where dateId = #{dateId}")                 //データ削除
            void delete(@Param("dateId")String dateId);
    }

