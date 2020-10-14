package com.example.demo.MapperTest;


import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppMapperTest {

    @Autowired
      AppMapper appM;

     @Test
     public void DBのデータを全件取得する() throws Exception{
         List<DateList> allData = appM.datelist();
         
     }


}
