package com.example.days.Controller;

import java.util.List;

import com.example.days.Service.AppService;
import com.example.days.domain.NameList.NameList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shift")
public class ShiftListController {
    @Autowired
    AppService service;
    
    @GetMapping
    public String startView(Model model){

        List<NameList> shiftOneList = service.listOne("シフト1");
        List<NameList> shiftTwoList = service.listOne("シフト2");
        List<NameList> shiftThreeList = service.listOne("シフト3");
        List<NameList> shiftFourList = service.listOne("シフト4");
        model.addAttribute("shiftOneList",shiftOneList);
        model.addAttribute("shiftTwoList",shiftTwoList );
        model.addAttribute("shiftThreeList",shiftThreeList );
        model.addAttribute("shiftFourList",shiftFourList );
        return "shift";
    }
    
    @PostMapping(params = "insert")
    public String insertName(@ModelAttribute NameList nameList){
        service.insertName(nameList);
        return "redirect:/shift";
    }
    @PostMapping(params = "delete")
    public String deleteName(@ModelAttribute NameList nameList){
        service.deleteName(nameList.getId());
        return "redirect:/shift";
    }
}
