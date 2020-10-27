package com.example.demo.MapperTest;

import java.util.List;

import com.example.demo.AppConfig;
import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@MybatisTest
@Import(AppConfig.class)
//@SpringBootApplication(scanBasePackages =  "com.example.demo.Mapper")
public class AppMapperTest {
    @Autowired
    AppConfig appConfig;


    @Test
    public void データを全件取得()throws Exception{
       List<DateList> li = appConfig.select();




    }



}
