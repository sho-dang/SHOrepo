package com.example.days.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.DayList;
import com.example.days.domain.DayMarge;
import com.example.days.domain.DaySplit;
import com.example.days.domain.NameList;
import com.example.days.domain.ShiftList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping
@Controller
public class DaysController {
    @Autowired
    AppService service;
    
    @GetMapping
    public String startView(){
        return "start";
    }
    @PostMapping("/shift")
    public String shiftList(Model model){
        List<NameList> nameList = service.nameListAll();
        List<NameList> shiftList = service.shiftList(nameList);
        
        //List<NameList> list = service.nameList();
        model.addAttribute("list", shiftList);
        return "index";
    }
}
