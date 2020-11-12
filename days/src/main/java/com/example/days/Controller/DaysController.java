package com.example.days.Controller;

import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.NameList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class DaysController {
    @Autowired
    AppService service;
    
    @GetMapping
    public String indexView(Model model){
        List<NameList> list = service.nameList();
        model.addAttribute("list",list);
        return "index";
    }

}
