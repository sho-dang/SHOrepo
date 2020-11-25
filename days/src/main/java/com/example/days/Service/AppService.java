package com.example.days.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.DayList;
import com.example.days.domain.DayMarge;
import com.example.days.domain.NameList;
import com.example.days.domain.ShiftList;
import com.example.days.domain.ShiftMarge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppService {
    
    @Autowired
    AppMapper am;

    

    public List<NameList> nameListAll(){
        List<NameList> list = am.listAll();
        return list;
    }
    public NameList listOne(String shift){
        NameList listOne = am.listOne(shift);
        return listOne;
    }
    
    public List<DayList> days(){
        List<DayList> days = am.days();
        return days;
    }
    public List<NameList> shiftList(List<NameList> list){
        ShiftList nameList = new ShiftList(list);
        List<NameList> shiftList = nameList.getNameList();
        return shiftList;
    }
}
