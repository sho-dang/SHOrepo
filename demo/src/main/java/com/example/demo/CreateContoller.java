package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/create")
@Controller
public class CreateContoller {


    @Autowired 
    DateService service;
    

    @GetMapping
    public String createView(@ModelAttribute DateList dateList){
       return "create";
    }

    @Transactional
    @PostMapping
    public String createData(@ModelAttribute("dateList") DateList dateList){
        service.create(dateList);    //引数にDateList型を入れれば新規作成を行う
        //model.addAttribute("newList", new DateList());
        DateList kk = dateList;
       return "index";
    }
    
}

