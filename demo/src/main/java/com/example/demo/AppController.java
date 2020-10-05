package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class AppController{
    @Autowired AppMapper appM;

    @GetMapping
    public String indexView(Model model){
       int N =  appM.year("3Y");
       model.addAttribute("num", N);
       List<DateList> list = appM.datelist();
       model.addAttribute("list", list);
        return "index";
    }


}