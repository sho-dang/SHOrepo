package com.example.days.domain;

import java.util.ArrayList;
import java.util.List;

public class ShiftList {
    
    private List<NameList> nameList;
    private List<String> listOne = new ArrayList<>();
    private List<String> listTwo = new ArrayList<>();
    private List<String> listThree = new ArrayList<>();
    private List<String> listFour = new ArrayList<>();

    public ShiftList(List<NameList> nameList){
        this.nameList = nameList;
        this.nameList.stream().forEach(s -> addList(s));
        }
    
    public List<NameList> getNameList(){
        return this.nameList;
    }
    public List<String> getListOne(){
        return this.listOne;
    }
    public List<String> getListTwo(){
        return this.listTwo;
    }
    public List<String> getListThree(){
        return this.listThree;
    }
    public List<String> getListFour(){
        return this.listFour;
    }
    public void setListOne(String listOne){
        this.listOne.add(listOne);
    }
    public void setListTwo(String listTwo){
        this.listTwo.add(listTwo);
    }
    public void setListThree(String listThree){
        this.listThree.add(listThree);
    }
    public void setListFour(String listFour){
        this.listFour.add(listFour);
    }
    public void addList(NameList nameList){
        switch(nameList.getShiftName()){
            case "シフト1":
                this.listOne.add(nameList.getNameList());
            break;
            case "シフト2":
                this.listTwo.add(nameList.getNameList());
            break;
            case "シフト3":
                this.listThree.add(nameList.getNameList());
            break;
            case "シフト4":
                this.listFour.add(nameList.getNameList());
            break;
    }
}
}