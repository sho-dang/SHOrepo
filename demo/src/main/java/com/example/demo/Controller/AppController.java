package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Service.DateService;
import com.example.demo.domain.DateConvert;
import com.example.demo.domain.DateFormula;
import com.example.demo.domain.DateList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    //th:field使用時にエラーが発生するので、GETしたときに使う仮の入れ物的なもの
    @ModelAttribute
    public DateConvert setDC(){
        return new DateConvert();
    }
    

    @GetMapping
    public String indexView(){
        return "index";
    }
    @PostMapping
    public String Calculated(@Validated DateConvert dateConvert,BindingResult bindingResult,Model model){
       if(bindingResult.hasErrors()){
           return "index";
       }

       List<DateList> list = service.dateLists();
       DateConvert df = new DateConvert(dateConvert.getValueYMD(),list);
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