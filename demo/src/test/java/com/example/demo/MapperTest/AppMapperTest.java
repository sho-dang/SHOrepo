package com.example.demo.MapperTest;

import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
//@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ComponentScan("mapper")
@MybatisTest
@SpringBootApplication(scanBasePackages =  "com.example.demo.Mapper")
public class AppMapperTest {
    @Autowired
    AppMapper appMapper;


    @Test
    public void データを全件取得()throws Exception{
       List<DateList> li = appMapper.datelist();




    }



}
