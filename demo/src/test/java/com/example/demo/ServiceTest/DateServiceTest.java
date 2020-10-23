package com.example.demo.ServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.swing.Spring;

import com.example.demo.Service.DateService;
import com.example.demo.domain.DateList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@MybatisTest
public class DateServiceTest {
   
    @Autowired
    DateService service;
   

/*
    public void set(){
      datelist.setDateId("test");
      datelist.setDateName("testName");
      datelist.setYear(6);
      datelist.setMonth(0);
      datelist.setYear(0);
    }
*/

    @Test
    public void データの取得ができる(){
        //set();
        List<DateList> list = service.dateLists();

        assertEquals(list.size(),1);
    }



    /*
    public List<DateList> dateLists(){
        List<DateList> serch =  appM.datelist();
        return serch;
        }

     public String calced(String valueYMD,DateList dateList){
        //LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedDate = LocalDate.parse(valueYMD, formatter);
        LocalDate dateCalced=parsedDate.plusYears(dateList.getYear()).plusMonths(dateList.getMonth()).plusDays(dateList.getDay());
        return dateCalced.format(formatter);
     }
     //List<DateList> dateList = appM.datelist();
    public DateList select(String dateId){
            DateList selectDate = appM.selectData(dateId);
            return selectDate;
    }
    @Transactional
    public void update(DateList dateList){
            appM.update(dateList);
    }

    @Transactional
    public void create(DateList dateList){
            appM.create(dateList);
    }

    public void delete(String dateId){
            appM.delete(dateId);
    }
   */
}