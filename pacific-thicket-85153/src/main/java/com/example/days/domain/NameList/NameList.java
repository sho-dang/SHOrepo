package com.example.days.domain.NameList;

public class NameList {

    private String id;
    private String nameList;
    private String shiftName;

    public String getId() {
        return id;
    }
    public String getNameList() {
        return this.nameList;
    }
    public String getShiftName() {
        return this.shiftName;
    }

    
    public void setId(String id) {
        this.id = id;
    }
    public void setNameList(String nameList){
        this.nameList = nameList;
    }
    public void setShiftName(String shiftName){
        this.shiftName = shiftName;
    }
}
