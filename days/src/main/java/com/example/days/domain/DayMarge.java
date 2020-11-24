package com.example.days.domain;

import java.util.ArrayList;
import java.util.List;

public class DayMarge {
    
    private List<DayList> dayList;
    
    public DayMarge(List<DayList> dayLists){
        this.dayList = dayLists;
        
        this.dayList.stream().forEach(e -> sp(e).getDayList());
    }
    public DaySplit sp(DayList dayList){
        return new DaySplit(dayList);
    }
    public List<DayList> getDayList(){
        return this.dayList;
    }

}
