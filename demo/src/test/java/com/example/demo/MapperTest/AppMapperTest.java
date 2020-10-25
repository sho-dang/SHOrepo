package com.example.demo.MapperTest;

import static org.junit.Assert.assertEquals;
import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@RunWith(SpringRunner.class)
//@MybatisTest
//@PropertySource("classpath:/src/test/resources/.properties")
@SpringBootTest
public class AppMapperTest{
  @Autowired
     AppMapper appM ;

     @Test
     public void DBのデータを全件取得() throws Exception{

        
         List<DateList> allData = appM.datelist();
         assertEquals(allData.size(), 4 );
     }



}
