package com.example.demo.MapperTest;

import static org.junit.Assert.assertEquals;
import java.util.List;
import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MybatisTest
//@PropertySource("classpath:/src/test/resources/.properties")
public class AppMapperTest{

   @Autowired
     AppMapper appM ;

     @Test
     public void DBのデータを全件取得する() throws Exception{
         List<DateList> allData = appM.datelist();
         assertEquals(allData.size(), 4 );
     }



}
