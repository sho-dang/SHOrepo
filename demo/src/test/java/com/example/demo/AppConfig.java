package com.example.demo;

import java.util.List;

import com.example.demo.Mapper.AppMapper;
import com.example.demo.domain.DateList;


import org.springframework.stereotype.Component;


@Component
public class AppConfig {
     private AppMapper appMapper;

     public AppConfig(AppMapper appMapper){
         this.appMapper = appMapper;
     }
     public List<DateList> select(){
         return this.appMapper.datelist();
     }
}
