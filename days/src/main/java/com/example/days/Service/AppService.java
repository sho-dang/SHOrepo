package com.example.days.Service;

import java.util.List;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.NameList.NameList;
import com.example.days.domain.NameList.ShiftList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppService {
    
    @Autowired
    AppMapper appMapper;

    public List<NameList> nameListAll(){
        List<NameList> list = appMapper.listAll();
        return list;
    }
    public List<NameList> listOne(String shiftName){
        List<NameList> listOne = appMapper.listOne(shiftName);
        return listOne;
    }
    public String convertName(String id){
        String convertName = appMapper.convertName(id);
        return convertName;
    }
    public String convertId(String nameList){
        String convertId = appMapper.convertId(nameList);
        return convertId;
    }
    public List<NameList> shiftList(List<NameList> list){
        ShiftList nameList = new ShiftList(list);
        List<NameList> shiftList = nameList.getNameList();
        return shiftList;
    }
    public List<DayList> days(){
        List<DayList> days = appMapper.days();
        return days;
    }
    public DayList selectDayList(int date){
        DayList selectDayList = appMapper.selectDayList(date);
        return selectDayList;
    }
    public String matchWorkId(int date){
        return appMapper.matchWorkId(date);
    }
    public String shiftPattern(int number){
        return appMapper.shiftPattern(number);
    }
    public void updateWorkId(int date,String inputCode){
        //シフトパターンNoが決定
        int countNumber = appMapper.number(inputCode);
        //intが４の場合,
        //スケジュールの日数だけくり返す
        for(int i = date ; i <= 30 ; i++){
            //一斉休暇日"9999"の場合はスキップする
            if(appMapper.matchWorkId(i).equals("9999")){
                continue;
            }
            //シフトパターンが入る"3214"etc ナンバーで指定
            String shiftPattern = shiftPattern(countNumber);
            appMapper.updateWorkId(shiftPattern,i);
            countNumber++;
            if(countNumber == 21){
                countNumber = 1;
            }
        }
        
    }
    public void updateVacationCode(String vacationId , int date){
        appMapper.updateVacationCode(vacationId, date);
    }
    public DayList convertNameList(DayList dayList){
        dayList.setVacationNameOne(convertNameMethod(dayList.getVacationNameOne()));
        dayList.setVacationNameTwo(convertNameMethod(dayList.getVacationNameTwo()));
        dayList.setVacationNameThree(convertNameMethod(dayList.getVacationNameThree()));
        dayList.setOverNameOne(convertNameMethod(dayList.getOverNameOne()));
        dayList.setOverNameTwo(convertNameMethod(dayList.getOverNameTwo()));
        dayList.setOverNameThree(convertNameMethod(dayList.getOverNameThree()));
        dayList.setEarlyNameOne(convertNameMethod(dayList.getEarlyNameOne()));
        dayList.setEarlyNameTwo(convertNameMethod(dayList.getEarlyNameTwo()));
        dayList.setEarlyNameThree(convertNameMethod(dayList.getEarlyNameThree()));
        return dayList;
    }
    public String convertNameMethod(String id){
        if(id != null){
            id = convertName(id);
        }
        return id;
    }
    public DayList convertIdList(DayList dayList){
        dayList.setVacationNameOne(convertIdMethod(dayList.getVacationNameOne()));
        dayList.setVacationNameTwo(convertIdMethod(dayList.getVacationNameTwo()));
        dayList.setVacationNameThree(convertIdMethod(dayList.getVacationNameThree()));
        dayList.setOverNameOne(convertIdMethod(dayList.getOverNameOne()));
        dayList.setOverNameTwo(convertIdMethod(dayList.getOverNameTwo()));
        dayList.setOverNameThree(convertIdMethod(dayList.getOverNameThree()));
        dayList.setEarlyNameOne(convertIdMethod(dayList.getEarlyNameOne()));
        dayList.setEarlyNameTwo(convertIdMethod(dayList.getEarlyNameTwo()));
        dayList.setEarlyNameThree(convertIdMethod(dayList.getEarlyNameThree()));
        return dayList;
    }
    public String convertIdMethod(String nameList){
        if(nameList != null){
            nameList = "XX";
        }else{
            nameList = convertId(nameList);
        }
        return nameList;
    }
    public String shiftInData(DayList dayList){
        String shiftInData = "";
        if(dayList.getShiftOne() != null){
            shiftInData = dayList.getShiftOne();
        }else if(dayList.getShiftTwo() != null){
            shiftInData = dayList.getShiftTwo();
        }else if(dayList.getShiftThree() != null){
            shiftInData = dayList.getShiftThree();
        }else if(dayList.getShiftFour() != null){
            shiftInData = dayList.getShiftFour();
        }
        return shiftInData;
    }
}
