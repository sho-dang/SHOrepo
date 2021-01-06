package com.example.days.domain.Day;

import java.util.List;

public class DayMerge {
    
    private List<DayList> dayList;
    
    public DayMerge(List<DayList> dayLists){
        this.dayList = dayLists;
        this.dayList.stream().forEach(e -> newDaySplit(e).getDayList());
    }
    public DaySplit newDaySplit(DayList dayList){
        return new DaySplit(dayList);
    }
    public List<DayList> getDayList(){
        return this.dayList;
    }

}
