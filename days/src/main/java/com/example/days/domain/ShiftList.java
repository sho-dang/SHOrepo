package com.example.days.domain;

import java.util.List;

public class ShiftList {

    private List<NameList> listOne ;
    private List<NameList> listTwo ;
    private List<NameList> listThree ;
    private List<NameList> listFour ;

    
    public List<NameList> getListOne(){
        return this.listOne;
    }
    public List<NameList> getListTwo(){
        return this.listTwo;
    }
    public List<NameList> getListThree(){
        return this.listThree;
    }
    public List<NameList> getListFour(){
        return this.listFour;
    }

    public void setListOne(List<NameList> listOne){
        this.listOne = listOne;
    }
    public void setListTwo(List<NameList> listTwo){
        this.listTwo = listTwo;
    }
    public void setListThree(List<NameList> listThree){
        this.listThree = listThree;
    }
    public void setListFour(List<NameList> listFour){
        this.listFour = listFour ;
    }



}
