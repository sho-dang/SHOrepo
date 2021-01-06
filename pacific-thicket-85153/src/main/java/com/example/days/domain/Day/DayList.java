package com.example.days.domain.Day;

import org.hibernate.validator.constraints.Range;

public class DayList {
    
    @Range(min = 1,max = 30)
    private int date;
    private String workId;
    private String vacationCode;

    private String shiftOne;
    private String shiftTwo;
    private String shiftThree;
    private String shiftFour;
    
    private String vacationNameOne;
    private String overNameOne;
    private String earlyNameOne;

    private String vacationNameTwo;
    private String overNameTwo;
    private String earlyNameTwo;

    private String vacationNameThree;
    private String overNameThree;
    private String earlyNameThree;

    

    public int getDate(){
        return this.date;
    }
    public String getWorkId(){
        return this.workId;
    }
    public String getVacationCode(){
        return this.vacationCode;
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
    
    public String getVacationNameOne() {
        return vacationNameOne;
    }
    public String getVacationNameTwo() {
        return vacationNameTwo;
    }
    public String getVacationNameThree() {
        return vacationNameThree;
    }
    public String getOverNameOne() {
        return overNameOne;
    }
    public String getOverNameTwo() {
        return overNameTwo;
    }
    public String getOverNameThree() {
        return overNameThree;
    }
    public String getEarlyNameOne() {
        return earlyNameOne;
    }
    public String getEarlyNameTwo() {
        return earlyNameTwo;
    }
    public String getEarlyNameThree() {
        return earlyNameThree;
    }




    public void setDate(int date){
        this.date = date;
    }
    public void setWorkId(String workId){
        this.workId = workId;
    }
    public void setVacationCode(String vacationCode){
        this.vacationCode = vacationCode;
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

    public void setVacationNameOne(String vacationNameOne) {
        this.vacationNameOne = vacationNameOne;
    }
    public void setVacationNameTwo(String vacationNameTwo) {
        this.vacationNameTwo = vacationNameTwo;
    }
    public void setVacationNameThree(String vacationNameThree) {
        this.vacationNameThree = vacationNameThree;
    }
    public void setOverNameOne(String overNameOne) {
        this.overNameOne = overNameOne;
    }
    public void setOverNameTwo(String overNameTwo) {
        this.overNameTwo = overNameTwo;
    }
    public void setOverNameThree(String overNameThree) {
        this.overNameThree = overNameThree;
    }
    public void setEarlyNameOne(String earlyNameOne) {
        this.earlyNameOne = earlyNameOne;
    }
    public void setEarlyNameTwo(String earlyNameTwo) {
        this.earlyNameTwo = earlyNameTwo;
    }
    public void setEarlyNameThree(String earlyNameThree) {
        this.earlyNameThree = earlyNameThree;
    }
}
