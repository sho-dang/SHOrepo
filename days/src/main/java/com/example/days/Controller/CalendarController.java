package com.example.days.Controller;

import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.DayList;
import com.example.days.domain.DayMarge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/list")
@Controller
public class CalendarController {
    @Autowired
    AppService service;

    @GetMapping
    public String createTable(Model model){
        List<DayList> days = service.days();
        DayMarge init = new DayMarge(days);
        model.addAttribute("days", init.getDayList());
        return "calendar";
    }
    

}
