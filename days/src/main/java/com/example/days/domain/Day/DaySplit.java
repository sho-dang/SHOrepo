package com.example.days.domain.Day;

public class DaySplit {
    
    private DayList dayList;
    
    //コンストラクタ
    public DaySplit(DayList dayList){
        this.dayList = dayList;
        splitWorkId(this.dayList.getWorkId());
        String[] fourSplit =vacationCodeSplit(this.dayList.getVacationCode());
        addList(subdivision(fourSplit[0]));
        addList(subdivision(fourSplit[1]));
        addList(subdivision(fourSplit[2]));
    };
    
    public void splitWorkId(String workId){
        String[] split = workId.split("");
        this.dayList.setShiftOne(split[0]);
        this.dayList.setShiftTwo(split[1]);
        this.dayList.setShiftThree(split[2]);
        this.dayList.setShiftFour(split[3]);
    }
    public DayList getDayList(){
        return this.dayList;
    }
    public String[] vacationCodeSplit(String vacationCode){
        String[] splitCode = {
                    vacationCode.substring(0,7),
                    vacationCode.substring(7,14),
                    vacationCode.substring(14,21),
                };
        return splitCode;
    }
    public String[] subdivision(String string){
        String[] subdivision = {
                string.substring(0,1),
                string.substring(1,3),
                string.substring(3,5),
                string.substring(5,7)
                };
        return subdivision;
    }
    public void addList(String[] string){
        switch(string[0]){
            case "1":
                if(string[1].equals("XX")){
                    this.dayList.setVacationNameOne("");
                }else{
                this.dayList.setVacationNameOne(string[1]);
                };
                if(string[2].equals("XX")){
                    this.dayList.setOverNameOne("");
                }else{
                    this.dayList.setOverNameOne(string[2]);
                };
                if(string[3].equals("XX")){
                    this.dayList.setEarlyNameOne("");
                }else{
                    this.dayList.setEarlyNameOne(string[3]);
                };
            break;
            case "2":
                if(string[1].equals("XX")){
                    this.dayList.setVacationNameTwo("");
                }else{
                    this.dayList.setVacationNameTwo(string[1]);
                };
                if(string[2].equals("XX")){
                    this.dayList.setOverNameTwo("");
                }else{
                    this.dayList.setOverNameTwo(string[2]);
                };
                if(string[3].equals("XX")){
                    this.dayList.setEarlyNameTwo(""); 
                }else{
                    this.dayList.setEarlyNameTwo(string[3]);
                };
            break;
            case "3":
                if(string[1].equals("XX")){
                    this.dayList.setVacationNameThree("");
                }else{
                    this.dayList.setVacationNameThree(string[1]);
                };
                if(string[2].equals("XX")){
                this.dayList.setOverNameThree("");
                }else{
                    this.dayList.setOverNameThree(string[2]);
                };
                if(string[3].equals("XX")){
                this.dayList.setEarlyNameThree("");
                }else{
                    this.dayList.setEarlyNameThree(string[3]);
                };
            }
        }
}
