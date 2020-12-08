package com.example.days.Controller;

import com.example.days.domain.Day.DayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class Register {

    @ModelAttribute
    public DayList setUp(){
        return new DayList();
    }

    @GetMapping
    public String registerMenu(@ModelAttribute DayList dayList){

        int i = dayList.getDate();
        String s = dayList.getShiftOne();

        return "register";
    }

}
