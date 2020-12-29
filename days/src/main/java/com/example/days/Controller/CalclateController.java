package com.example.days.Controller;



import com.example.days.Service.AppService;
import com.example.days.domain.UpdateCode.UpdateCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String calcReturn(@Validated @ModelAttribute UpdateCode updateCode,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "calclate";
        }
        int inputDate = updateCode.getInputDate();
        String inputCode = updateCode.getInputCode();
        service.updateWorkId(inputDate, inputCode);
        return "redirect:/calendar";
    }

}
