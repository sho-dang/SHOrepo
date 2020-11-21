package com.example.days.Service;

import java.util.List;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.DayList;
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
    
    public List<DayList> days(){
        List<DayList> days = am.days();
        return days;
    }
    public List<DaySplit> workCode(int date){
        List<DaySplit> workCode = am.workCode(date);
        return workCode;
    }
    public List<DayList> WorkDay(List<DayList> dayList,List<DaySplit> daySplit){
        List<DayList> day = dayList;
        List<DaySplit> workId = daySplit;

        
    }

}
