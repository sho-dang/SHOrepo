package com.example.demo.MapperTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AppMapperTest{

    @Autowired
     private AppMapper appM;



     @Test
     public void DBのデータを全件取得する() throws Exception{
         List<DateList> allData = appM.datelist();
         assertEquals(allData.size(), 4 );
     }



}
