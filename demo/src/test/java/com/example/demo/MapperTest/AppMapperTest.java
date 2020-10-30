package com.example.demo.MapperTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMapperTest {
    @Autowired
    AppMapper appMapper;


    @Test
    public void データを全件取得()throws Exception{
       List<DateList> li = appMapper.datelist();
       assertEquals(li.size(), 4);



    }



}
