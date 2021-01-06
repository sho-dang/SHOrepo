package com.example.days.domain.UpdateCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class UpdateCode {
    
    @Range(min = 1,max = 30)
    private int inputDate;

    @NotBlank
    @Pattern(regexp = "^[1-4]{5}")
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
