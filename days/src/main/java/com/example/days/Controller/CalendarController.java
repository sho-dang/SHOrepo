package com.example.days.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.Day.DayMarge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/list")
@Controller
public class CalendarController {
    @Autowired
    AppService service;

    @GetMapping
    public String createTable(Model model,@ModelAttribute DayList dayList){

        List<DayList> days = service.days();
        DayMarge init = new DayMarge(days);
        model.addAttribute("days", init.getDayList());


        List<DayList>  li = new ArrayList<>();
        init.getDayList().stream()
                .filter(d -> d.getWorkId().equals("9999"))
                .forEach(d -> li.add(d));
        model.addAttribute("holiday",li);

/*
        //
        String[] shiftNameList = {"シフト1","シフト2","シフト3","シフト4"};
        List<NameList> shiftListOne = service.listOne(shiftNameList[0]);
        List<NameList> shiftListTwo = service.listOne(shiftNameList[1]);
        List<NameList> shiftListThree = service.listOne(shiftNameList[2]);
        List<NameList> shiftListFour = service.listOne(shiftNameList[3]);
        
        model.addAttribute("one", shiftListOne);
        model.addAttribute("two", shiftListTwo);
        model.addAttribute("three", shiftListThree);
        model.addAttribute("four", shiftListFour);
*/

        return "calendar";
    }
    @GetMapping("/list/update/{day}/{code}")
    public String nameSet(@PathVariable("day")int day,@PathVariable("code") String code){
        int d = day;
        String c = code;
        //@PathVariable("day")int day,@PathVariable("code") String code
        return "calendar";
    }

}
