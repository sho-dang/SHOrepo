package com.example.days.domain.UpdateCode;

import javax.validation.constraints.NotBlank;

public class UpdateCode {
    
    @NotBlank(message = "入力してください")
    private int inputDate;
    @NotBlank(message = "入力してください")
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
