package com.example.demo;

public class DateList {
    private String dateId;

    private String dateName;

    private int year ;

    private int month ;

    private int day;


    public String getDateId(){
        return this.dateId;
    }

    public String getDateName(){
        return this.dateName;
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }


    public void setDateId(String dateId){
        this.dateId = dateId;
    }

    public void setDateName(String dateName){
        this.dateName = dateName;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setDay(int day){
        this.day = day;
    }
    
}
