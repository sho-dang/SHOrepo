package com.example.days.Controller;

import java.util.ArrayList;
import java.util.List;


import com.example.days.Service.AppService;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.Day.DayMerge;
import com.example.days.domain.Day.DaySplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calendar")
@Controller
public class CalendarController {
    @Autowired
    AppService service;

    @GetMapping
    public String viewCalendar(Model model,@ModelAttribute DayList dayList){

        DayMerge init = new DayMerge(service.days());
        List<DayList> days = init.getDayList();
        days.stream().forEach(d -> service.convertNameList(d));
        model.addAttribute("days", days);

        List<DayList>  holiday = new ArrayList<>();
        init.getDayList().stream()
                .filter(d -> d.getWorkId().equals("9999"))
                .forEach(d -> holiday.add(d));
        model.addAttribute("holiday",holiday);

        return "calendar";
    }

    @PostMapping
    public String nameSet(@ModelAttribute DayList dayList){
        //名前をIDに変換
        DayList convertDayList = service.convertIdList(dayList);

        //元のDayListを取得
        DaySplit selectDayList = new DaySplit(service.selectDayList(convertDayList.getDate()));
        DayList newDayList =service.convertNullEmpty(selectDayList.getDayList());

        //データが入っているシフトの書き換え
        DayList resultDayList = service.convertDayList(newDayList, convertDayList);
        int date = resultDayList.getDate();
        String newVacationCode = service.linkNewVacationCode(resultDayList);
        service.updateVacationCode(newVacationCode,date);
        
        //@PathVariable("day")int day,@PathVariable("code") String code
        return "redirect:/calendar";
    }

    @PostMapping(params = "update")
    public String holidayUpdate(@Validated @ModelAttribute DayList dayList,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return viewCalendar(model, dayList);
        }
        service.updateAllVacation(dayList.getDate());
        return "redirect:/calendar";
    }

    @PostMapping(params = "delete")
    public String holidayReset(@Validated @ModelAttribute DayList dayList,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return viewCalendar(model, dayList);
        }
        service.deleteAllVacation(dayList.getDate());
        return "redirect:/calendar";
    }

}
