package com.example.days.domain.UpdateCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class UpdateCode {
    
    
    @Range(min = 1,max = 30,message = "日付が存在しません")
    private int inputDate;

    @NotBlank(message = "入力してください")
    @Pattern(regexp = "^[1-4]{5}",message = "5桁の数字をを正しく入力してください")
    private String inputCode;
    
    public int getInputDate(){
        return this.inputDate;
    }
    public String getInputCode(){
        return this.inputCode;
    }

    public void setInputDate(int inputDate){
        this.inputDate = inputDate;
    }
    public void setInputCode(String inputCode){
        this.inputCode = inputCode;
    }

}
