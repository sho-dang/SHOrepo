package com.example.days.domain.Day;

public class DaySplit {
    
    private DayList dayList;
    
    //コンストラクタ
    public DaySplit(DayList dayList){
        this.dayList = dayList;
        splitWorkId(this.dayList.getWorkId());
    };
    
    public void splitWorkId(String workId){
        String[] split = workId.split("");
        this.dayList.setShiftOne(split[0]);
        this.dayList.setShiftTwo(split[1]);
        this.dayList.setShiftThree(split[2]);
        this.dayList.setShiftFour(split[3]);
    }
    public DayList getDayList(){
        return this.dayList;
    }
}
