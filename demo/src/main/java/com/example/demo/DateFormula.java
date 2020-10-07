package com.example.demo;

import java.util.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class DateFormula {

    private DateList dateList;    //クラス型　 ここではゲットセットを使える　型を定義しただけ？
    private String dateCalc;      //計算結果を入れる


    public DateFormula(DateList dateList){
          this.dateList= dateList;          //コンストラクタ定義　引数にDateListのフィールドを入れれば持ってこれる？
    }                                       //this  は private DateList dateList;のことを指している

    public String getDateId(){
        return dateList.getDateId();        //コンストラクタ１　日付ID
    }

    public String getDateName(){
        return dateList.getDateName();      //コンストラクタ２　日付名
    }

    public String getDateCalc(){
        return this.dateCalc;
    }

    public void setDateCalc(String dateCalc){
          this.dateCalc= dateCalc;
    }


    public String ymdCalcration(){
        int[] YMDList = {dateList.getYear(),dateList.getMonth(),dateList.getDay()};
        StringJoiner joinYMD = new StringJoiner("/");
        Arrays.stream(YMDList).forEach(i -> joinYMD.add(String.valueOf(i)));
/*
        List<Integer> ymd = Arrays.asList(dateList.getYear(),dateList.getMonth(),dateList.getDay());
        String YMD = ymd.stream()
          .map(i -> i.toString())
          .collect(Collectors.joining(",/"));
*/


        return joinYMD.toString();
    }

}
