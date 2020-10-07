package com.example.demo;

public class DateFormula {

    private DateList dateList;    //クラス型　 ここではゲットセットを使える　インスタンスではない？
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
    /*
　　public String ymdCalcration(){
    return ;
    }
*/
}
