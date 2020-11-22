package com.example.days.domain;

import java.util.ArrayList;
import java.util.List;

public class DayMarge {
    
    private List<DayList> dayList;
    
    public DayMarge(DayList dayList,DaySplit daySplit){
        this.dayList = new ArrayList<>();
        this.dayList.stream().forEach(i -> this.dayList.add(marge(dayList, daySplit)));
    }
    public List<DayList> getDayList(){
        return this.dayList;
    }

    public DayList marge(DayList dayList,DaySplit daySplit){
        DaySplit dayIns = new DaySplit(dayList, daySplit);
        return dayIns.getDayList();
        

    }


}
