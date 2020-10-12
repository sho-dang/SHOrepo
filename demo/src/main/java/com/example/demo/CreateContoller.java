package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/create")
@Controller
public class CreateContoller {


    @Autowired 
    DateService service;
    DateFormula dateFormula;

    @GetMapping
    public String createView(){
       return "create";
    }

/*
    @PostMapping
    public String updateData(Model model){

       return "update";
    }
}
*/
}