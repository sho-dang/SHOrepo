package com.example.demo.MapperTest;

import static org.junit.Assert.assertEquals;
import java.util.List;
import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//@RunWith(SpringRunner.class)
@SpringBootApplication
public class AppMapperTest{

   
     AppMapper appM ;


     @Test
     public void DBのデータを全件取得する() throws Exception{
         List<DateList> allData = appM.datelist();
         assertEquals(allData.size(), 4 );
     }



}
