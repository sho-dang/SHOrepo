package com.example.days.Controller;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.ArrayList;
import java.util.List;

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
        /* 休暇日指定
        LocalDate date = LocalDate.of(2020,11,01);
        LocalDate l = date.with(TemporalAdjusters.lastDayOfMonth());
        List<Integer> dateList = new ArrayList<Integer>();
        for(int i = 1 ; i <= l.getDayOfMonth() ; i++){
            dateList.add(i);
        }
        model.addAttribute("date",dateList);
        */
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
