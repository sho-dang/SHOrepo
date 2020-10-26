package com.example.demo.ServiceTest;

import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.MapperTest.AppMapperTest;
import com.example.demo.Service.DateService;
import com.example.demo.domain.DateList;

import org.junit.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateServiceTest {
    @Autowired
    DateService ser = new DateService();
    DateList de;

    @Test
    public void 全件取得()throws Exception{
       // DateService ser = new DateService();
         List<DateList> li = ser.dateLists();
         System.out.println(li);
    }

}
