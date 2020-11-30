package com.example.days.Controller;

import com.example.days.Service.AppService;
import com.example.days.domain.UpdateCode.UpdateCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/calclate")
@Controller
public class CalclateController {
    @Autowired
    AppService service;

    @GetMapping
    public String calcShift(Model model){
        model.addAttribute("updateCode",new UpdateCode());
        return "calclate";
    }

    @PostMapping
    public String calcReturn(@ModelAttribute UpdateCode updateCode){
        int inputDate = updateCode.getInputDate();
        String inputCode = updateCode.getInputCode();
        service.updateMethod(inputDate, inputCode);
        return "calendar";
    }

}
