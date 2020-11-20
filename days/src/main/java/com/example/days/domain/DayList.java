package com.example.days.domain;

public class DayList {
    
    private int date;
    private String shiftOne;
    private String shiftTwo;
    private String shiftThree;
    private String shiftFour;


    public int getDate(){
        return this.date;
    }
    public String getShiftOne(){
        return this.shiftOne;
    }
    public String getShiftTwo(){
        return this.shiftTwo;
    }
    public String getShiftThree(){
        return this.shiftThree;
    }
    public String getShiftFour(){
        return this.shiftFour;
    }

    public void setDate(int date){
        this.date = date;
    }
    public void setShiftOne(String shiftOne){
        this.shiftOne = shiftOne;
    }
    public void setShiftTwo(String shiftTwo){
        this.shiftTwo = shiftTwo;
    }
    public void setShiftThree(String shiftThree){
        this.shiftThree = shiftThree;
    }
    public void setShiftFour(String shiftFour){
        this.shiftFour = shiftFour;
    }

}
