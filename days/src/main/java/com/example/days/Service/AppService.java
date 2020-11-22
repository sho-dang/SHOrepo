package com.example.days.Service;

import java.util.List;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.DayList;
import com.example.days.domain.DayMarge;
import com.example.days.domain.DaySplit;
import com.example.days.domain.NameList;
import com.example.days.domain.ShiftList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppService {
    
    @Autowired
    AppMapper am;

    

    public List<NameList> nameList(){
        List<NameList> list = am.list();
        return list;
    }
    public List<NameList> listOne(String shift){
        List<NameList> listOne = am.listOne(shift);
        return listOne;
    }
    
    public DayList days(){
        DayList days = am.days();
        return days;
    }
    public DaySplit workCode(){
        DaySplit workCode = am.workCode();
        return workCode;
    }
    public List<DayList> WorkDay(DayList dayList,DaySplit daySplit){
        DayMarge marge = new DayMarge(dayList, daySplit);
        return marge.getDayList();
    }

}
