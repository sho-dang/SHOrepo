package com.example.days.Mapper;

import java.util.List;

import com.example.days.domain.NameList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppMapper {
    @Select("SELECT * FROM shiftmember")
    List<NameList> list();

}
