package com.example.days.domain.Vacation;

public class VacationSplit {
    private VacationList vacationList;

    
    
    public VacationSplit(VacationList vacationList){
        this.vacationList = vacationList;
        String[] fourSplit =vacationCodeSplit(this.vacationList.getVacationCode());
        addList(subdivision(fourSplit[0]));
        addList(subdivision(fourSplit[1]));
        addList(subdivision(fourSplit[2]));
        addList(subdivision(fourSplit[3]));
    }
    public VacationList getVacationList(){
        return this.vacationList;
    }
    public String[] vacationCodeSplit(String vacationCode){
        String[] splitCode = {
                    vacationCode.substring(0,7),
                    vacationCode.substring(7,14),
                    vacationCode.substring(14,21),
                    vacationCode.substring(21,28)
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
                this.vacationList.setVacationNameOne(string[1]);
                this.vacationList.setOverNameOne(string[2]);
                this.vacationList.setEarlyNameOne(string[3]); 
            break;
            case "2":
                this.vacationList.setVacationNameTwo(string[1]);
                this.vacationList.setOverNameTwo(string[2]);
                this.vacationList.setEarlyNameTwo(string[3]); 
            break;
            case "3":
                this.vacationList.setVacationNameThree(string[1]);
                this.vacationList.setOverNameThree(string[2]);
                this.vacationList.setEarlyNameThree(string[3]); 
            break;
            case "4":
                this.vacationList.setVacationNameFour(string[1]);
                this.vacationList.setOverNameFour(string[2]);
                this.vacationList.setEarlyNameFour(string[3]); 
            break;
    }

}


}