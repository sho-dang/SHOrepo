package com.example.days.Controller;

import com.example.days.Service.AppService;
import com.example.days.domain.UpdateCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/calcrate")
@Controller
public class CalcrateController {
    @Autowired
    AppService service;

    @GetMapping
    public String calcShift(Model model){
        model.addAttribute("updateCode",new UpdateCode());
        return "calcrate";
    }

    @PostMapping
    public String calcReturn(@ModelAttribute UpdateCode updateCode){
        int num = 1;
        String st = "34422";
        service.updateMethod(num, st);


        return "calcrate";
    }

}
