package com.example.days.domain.Vacation;

import java.util.List;

public class VacationMarge {
    
    private VacationList vacation;
    private List<VacationList> vacationList;


    public  VacationMarge(List<VacationList> inputList ){
        this.vacationList = inputList;
        this.vacationList.stream().forEach(v -> convertList(v).getVacationList());
    }
    public List<VacationList> getVacationList(){
        return this.vacationList;
    }
    public void setVacationList(List<VacationList> vacationList) {
        this.vacationList = vacationList;
    }
    
    public VacationSplit convertList(VacationList vacationList){
        return new VacationSplit(vacationList);
    }

}
