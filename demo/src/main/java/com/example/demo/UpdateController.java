package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/update")
@Controller
public class UpdateController {
    @Autowired 
    DateService service;
    DateFormula dateFormula;

    @GetMapping
    public String indexView(Model model){
       
       DateFormula dd =new DateFormula(service.select("3Y"));
       
       model.addAttribute("list", dd);
        return "update";
    }


}