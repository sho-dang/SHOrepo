package com.example.days.domain;

import java.util.List;

public class DaySplit {
    
    private DayList dayList;
    private String workId;

    //ゲッター
    public String getWorkId(){
        return this.workId;
    }
    //セッター
    public void setDate(String workId){
        this.workId = workId;
    }

    public List<DayList> splitCode(DayList dayList){
        String[] splitCode = workId.split("");
        //{1,2,3,0}
        dayList.setShiftOne(splitCode[0]);
        dayList.setShiftTwo(splitCode[1]);
        dayList.setShiftThree(splitCode[2]);
        dayList.setShiftFour(splitCode[3]);
        
        return 
    }
}
