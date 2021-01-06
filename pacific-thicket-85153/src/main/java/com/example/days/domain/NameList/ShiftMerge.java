package com.example.days.domain.NameList;

import java.util.List;

public class ShiftMerge {
    
    private List<ShiftList> shiftList;

    public ShiftMerge(List<NameList> nameList){
       // nameList.stream().forEach(s -> addList(s));
    }
    public List<ShiftList> getShiftList(){
        return this.shiftList ;
    }
    
    
}
