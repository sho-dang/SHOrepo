package com.example.days.domain.NameList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class NameList {

    @NotBlank(message = "※IDを入力してください")
    @Pattern(regexp = "^$|[A-Z]{2}",message = "※IDは「大文字のアルファベット２文字」で入力してください")
    private String id;

    @NotBlank(message = "※名前を入力してください")
    @Size(max = 10,message = "※名前は10文字以下で入力してください")
    private String nameList;

    @NotBlank(message = "※シフト名を入力してください")
    @Pattern(regexp = "^$|シフト(1|2|3|4)",message = "※シフト名は「シフト1」「シフト2」「シフト3」「シフト4」のいずれかを入力してください")
    private String shiftName;

    public String getId() {
        return id;
    }
    public String getNameList() {
        return this.nameList;
    }
    public String getShiftName() {
        return this.shiftName;
    }

    
    public void setId(String id) {
        this.id = id;
    }
    public void setNameList(String nameList){
        this.nameList = nameList;
    }
    public void setShiftName(String shiftName){
        this.shiftName = shiftName;
    }
}
