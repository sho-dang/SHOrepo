package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Service.DateService;
import com.example.demo.domain.DateConvert;
import com.example.demo.domain.DateFormula;
import com.example.demo.domain.DateList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping
@Controller
public class AppController{
    @Autowired 
    DateService service;
    DateList dateList;
    DateConvert dateConvert;
    DateFormula dateFormula;

    @GetMapping
    public String indexView(Model model){
        return "index";
    }
    @PostMapping
    public String Calculated(@RequestParam(name="textData")String text,Model model){
        
        List<DateList> list = service.dateLists();
       DateConvert df = new DateConvert(text,list);
       List<DateFormula> listDF = df.getDateFormula();
       listDF.stream().forEach(e -> e.setYmdCalclation());
       listDF.stream().forEach(e -> e.setDateResult(service.calced(df.getValueYMD(),e.getDateList())));
       model.addAttribute("list", listDF);
        return "index";
    }
    @PostMapping("{dateId}")
    public String delete(@PathVariable("dateId") String dateId){
        service.delete(dateId);
        return "index";
    }

}