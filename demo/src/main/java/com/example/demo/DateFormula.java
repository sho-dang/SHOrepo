package com.example.demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class DateFormula {

      /*メモ
         このクラス型でできること

         DateListコンストラクタの取得
             dateId,dateName,year,month,day,dateCalc

             インスタンス化したときに初めてDateListのデータがすべて参照される？？
         dateIdの取得
         dateNameの取得
         dateCalcの取得
         dateCalcの登録
         ymdCalclationの使用　
         　　　　⇒　returnは取得したDateList　y,m,dの連結（y/m/d）



      */




    private DateList dateList;    //クラス型　 ここではゲットセットを使える　型を定義しただけ？
    private String dateResult;      //計算結果を入れる
    private String dateCalc;

    public DateFormula(DateList dateList){   //インスタンス作成されてた時に行う初期設定
          this.dateList= dateList;           //this  は private DateList dateList;のことを指している
    }

    public String getDateId(){
        return dateList.getDateId();        //コンストラクタ１　日付ID
    }

    public String getDateName(){
        return dateList.getDateName();      //コンストラクタ２　日付名
    }
    public DateList getDateList(){
        return this.dateList;
    }


    /*
     DateFormula型でDateListの値を呼び出すときゲットで呼び出していないと使えない
     （呼び出していたdateId,dateNameはエラーにならなかった）

     public int getYear(){
        return dateList.getYear();      //コンストラクタ２　日付名
    }
    public int getMonth(){
        return dateList.getMonth();      //コンストラクタ２　日付名
    }
    public int getDay(){
        return dateList.getDay();      //コンストラクタ２　日付名
    }
    */


    public String getDateResult(){
        return this.dateResult;
    }
    public void setDateResult(String dateResult){
        this.dateResult=dateResult;
    }
    public String getDateCalc(){
        return this.dateCalc;
    }

    public void setDateCalc(String dateCalc){
          this.dateCalc= dateCalc;
    }


    public void setYmdCalclation(){
        int[] YMDList = {dateList.getYear(),dateList.getMonth(),dateList.getDay()};
        StringJoiner joinYMD = new StringJoiner("/");
        Arrays.stream(YMDList).forEach(i -> joinYMD.add(String.valueOf(i)));
/*
        List<Integer> ymd = Arrays.asList(dateList.getYear(),dateList.getMonth(),dateList.getDay());
        String YMD = ymd.stream()
          .map(i -> i.toString())
          .collect(Collectors.joining("/"));
*/


        this.dateCalc=joinYMD.toString();
    }

}
