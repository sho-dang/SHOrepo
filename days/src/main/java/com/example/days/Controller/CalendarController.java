package com.example.days.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.Day.DayMarge;
import com.example.days.domain.NameList.NameList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<DayList>  li = new ArrayList<>();

        init.getDayList().stream().filter(d -> d.getWorkId().equals("9999"))
                    .forEach(d -> li.add(d));

        String[] shiftNameList = {"シフト1","シフト2","シフト3","シフト4"};
        List<NameList> shiftListOne = service.listOne(shiftNameList[0]);
        List<NameList> shiftListTwo = service.listOne(shiftNameList[1]);
        List<NameList> shiftListThree = service.listOne(shiftNameList[2]);
        List<NameList> shiftListFour = service.listOne(shiftNameList[3]);

        model.addAttribute("days", init.getDayList());
        model.addAttribute("holiday",li);
        model.addAttribute("one", shiftListOne);
        model.addAttribute("two", shiftListTwo);
        model.addAttribute("three", shiftListThree);
        model.addAttribute("four", shiftListFour);

        return "calendar";
    }
    

}
