package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class DateConvert {

       //入力された年月日をStringとして読み込みたい　⇒　valueYMD
       /*
          dateId
          dateName
          year
          month
          day
          dateCalc
          List型でDateFormulaをまとめ、コンストラクタとする
          そのリストに計算結果を結合する
          インスタンス化して引数を渡されたとき、フィールドの値が代入される
          ListをListに格納？
       */
      @NotBlank(message = "日付を入力してください")
      @Pattern(regexp = "\\d{8}",message = "日付を正しく入力してください　例：20201201")
       private String valueYMD;
       private List<DateFormula> dateFormula;


       public DateConvert (){
       }

       public DateConvert(String valueYMD,List<DateList> dateList){
             this.valueYMD = valueYMD;
             this.dateFormula = new ArrayList<>();
             dateList.stream().forEach(e -> this.dateFormula.add(dateFormulaInstance(e)));
       }

       public String getValueYMD(){
           return this.valueYMD;
       }
       public void setValueYMD(String valueYMD){
           this.valueYMD = valueYMD;
       }
       public List<DateFormula> getDateFormula(){
           return this.dateFormula;
       }
       //ここが実行されたときDateFormulaがインスタンス化される　DateList5つのフィールドが反映
       //値が入るのはdateId,dateName,year,month,day
       public DateFormula dateFormulaInstance(DateList dateList){
           return new DateFormula(dateList);
       }


}
