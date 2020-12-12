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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/list")
@Controller
public class CalendarController {
    @Autowired
    AppService service;

    @ModelAttribute
    public DayList setUp(){
        return new DayList();
    }

    @GetMapping
    public String createTable(Model model,@ModelAttribute DayList dayList){

        
        DayMerge init = new DayMerge(service.days());
        List<DayList> days = init.getDayList();
        days.stream().forEach(d -> service.convertNameList(d));
        model.addAttribute("days", days);


        List<DayList>  holiday = new ArrayList<>();
        init.getDayList().stream()
                .filter(d -> d.getWorkId().equals("9999"))
                .forEach(d -> holiday.add(d));
        model.addAttribute("holiday",holiday);

/*未使用
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
        model.addAttribute("at", dayList );
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
        switch(service.shiftInData(convertDayList)){
            case "1":
            newDayList.setVacationNameOne(convertDayList.getVacationNameOne());
            newDayList.setOverNameOne(convertDayList.getOverNameOne());
            newDayList.setEarlyNameOne(convertDayList.getEarlyNameOne());
            break;
            case "2":
            newDayList.setVacationNameTwo(convertDayList.getVacationNameTwo());
            newDayList.setOverNameTwo(convertDayList.getOverNameTwo());
            newDayList.setEarlyNameTwo(convertDayList.getEarlyNameTwo());
            break;
            case "3":
            newDayList.setVacationNameThree(convertDayList.getVacationNameThree());
            newDayList.setOverNameThree(convertDayList.getOverNameThree());
            newDayList.setEarlyNameThree(convertDayList.getEarlyNameThree());
            break;
        }
        newDayList.setVacationCode(
            "1" + newDayList.getVacationNameOne() + newDayList.getOverNameOne() + newDayList.getEarlyNameOne() +
            "2" + newDayList.getVacationNameTwo() + newDayList.getOverNameTwo() + newDayList.getEarlyNameTwo() +
            "3" + newDayList.getVacationNameThree() + newDayList.getOverNameThree() + newDayList.getEarlyNameThree()
            );
        service.updateVacationCode(newDayList.getVacationCode(),newDayList.getDate());
        
        //@PathVariable("day")int day,@PathVariable("code") String code
        return "redirect:/list";
    }

}
