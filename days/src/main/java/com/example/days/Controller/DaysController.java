package com.example.days.Controller;

import java.util.ArrayList;
import java.util.List;

import com.example.days.Service.AppService;
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
    public String indexView(@ModelAttribute ShiftList shiftList,Model model){

        
        shiftList.setListOne(service.listOne("シフト1"));

        List<NameList> list = service.nameList();
        List<NameList> listOne = service.listOne("シフト1");
        List<NameList> listTwo = service.listOne("シフト2");
        List<NameList> listThree = service.listOne("シフト3");
        List<NameList> listFour = service.listOne("シフト4"); 

       
        
        model.addAttribute("list1", shiftList);
        //model.addAttribute("list2", listTwo);
        //model.addAttribute("list3", listThree);
        //model.addAttribute("list4", listFour);
        return "index";
    }
    @PostMapping
    public String createTable(){
        return "index";
    }

}