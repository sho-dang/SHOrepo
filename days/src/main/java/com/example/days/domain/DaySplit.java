package com.example.days.domain;

import java.util.List;

public class DaySplit {
    
    private DayList dayList;
    private String workId;

    //ゲッター
    public String getWorkId(){
        return this.workId;
    }
    public DayList getDayList(){
        return this.dayList;
    }

    //セッター
    public void setWorkId(String workId){
        this.workId = workId;
    }

    public void splitCode(){
        String[] splitCode = this.workId.split("");
        //{1,2,3,0}
         
    }
}
