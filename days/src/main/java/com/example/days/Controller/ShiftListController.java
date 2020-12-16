package com.example.days.Controller;

import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.NameList.NameList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shift")
public class ShiftListController {
    @Autowired
    AppService service;
    
    @GetMapping
    public String startView(Model model){
        List<NameList> nameList = service.nameListAll();
        List<NameList> shiftList = service.shiftList(nameList);
        model.addAttribute("list", nameList);
        return "shift";
    }
    /*
    @PostMapping
    public String shiftList(){
        return "shift";
    }
    */
}
