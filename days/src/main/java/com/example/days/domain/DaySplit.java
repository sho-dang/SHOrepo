package com.example.days.domain;

public class DaySplit {
    
    private DayList dayList;
    private String workId;
    
    //コンストラクタ
    public DaySplit(DayList dayList,DaySplit daySplit){
        this.dayList = dayList;
        String[] splitCode = this.workId.split("");
        this.dayList.setShiftOne(splitCode[0]);
        this.dayList.setShiftOne(splitCode[1]);
        this.dayList.setShiftOne(splitCode[2]);
        this.dayList.setShiftOne(splitCode[3]);
    }

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

   
    
}
