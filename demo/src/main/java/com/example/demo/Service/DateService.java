package com.example.demo.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class DateService {

        @Autowired
        AppMapper appMapper;


        public List<DateList> dateLists(){
            List<DateList> serch =  appMapper.datelist();
            return serch;
            }

         public String calced(String valueYMD,DateList dateList){
            //LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd").withResolverStyle(ResolverStyle.LENIENT);;
            LocalDate parsedDate = LocalDate.parse(valueYMD, formatter);
            LocalDate dateCalced=parsedDate.plusYears(dateList.getYear()).plusMonths(dateList.getMonth()).plusDays(dateList.getDay());
            return dateCalced.format(formatter);
         }
         //List<DateList> dateList = appM.datelist();
        public DateList select(String dateId){
                DateList selectDate = appMapper.selectData(dateId);
                return selectDate;
        }
        @Transactional
        public void update(DateList dateList){
                appMapper.update(dateList);
        }

        @Transactional
        public void create(DateList dateList){
                appMapper.create(dateList);
        }

        public void delete(String dateId){
                appMapper.delete(dateId);
        }



}
