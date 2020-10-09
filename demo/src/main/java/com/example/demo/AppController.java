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
    @Autowired 
    AppMapper appM;
    DateService service;
    DateList dateList;
    
    DateFormula dateFormula;

    @GetMapping
    public String indexView(Model model){
       //int N =  appM.year("3Y");
       //model.addAttribute("num", N);
       List<DateList> list = appM.datelist();
      //model.addAttribute("list", list);

       DateConvert df = new DateConvert("20200101",list);
       List<DateFormula> listDF = df.getDateFormula();
       listDF.stream().forEach(e -> dateFormula.setYmdCalclation());
       //listDF.stream().forEach(e -> e.setDateCalc(service.calced(df.getValueYMD())));
       model.addAttribute("list", listDF);
        return "index";
    }


}