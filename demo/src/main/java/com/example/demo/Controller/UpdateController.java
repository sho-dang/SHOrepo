package com.example.demo.Controller;


import com.example.demo.Service.DateService;
import com.example.demo.domain.DateFormula;
import com.example.demo.domain.DateList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/update/{dateId}")
@Controller
public class UpdateController {
    @Autowired 
    DateService service;
    DateFormula dateFormula;

    @GetMapping
    public String updateView(@PathVariable("dateId") String dateId ,Model model){
      // DateFormula dd =new DateFormula(service.select(dateId));   //Dateformulaに入れてdateCalcとdateResultも取り出したいとき
       DateList selectData = service.select(dateId);   //DateListから直接値を持ってくるとき
       model.addAttribute("list", selectData);
       return "update";
    }

    @PostMapping
    public String updateData(@PathVariable("dateId") String dateId,@ModelAttribute DateList dateList ){
      service.update(dateList);
       return "index";
    }

}