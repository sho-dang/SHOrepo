package com.example.days.domain.NameList;

import java.util.List;

public class ShiftMarge {
    
    private List<ShiftList> shiftList;

    public ShiftMarge(List<NameList> nameList){
       // nameList.stream().forEach(s -> addList(s));
    }
    public List<ShiftList> getShiftList(){
        return this.shiftList ;
    }
    
    
}
