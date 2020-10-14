package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class DateService {

        @Autowired
        AppMapper appM;


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



}
