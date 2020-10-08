package com.example.demo;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {

        @Autowired
        AppMapper appM;

         public String calced(String valueYMD,List<DateList> dateList){
            //LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate parsedDate = LocalDate.parse(valueYMD, formatter);
            return null;
         }
         //List<DateList> dateList = appM.datelist();





}
