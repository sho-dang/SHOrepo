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
    public List<NameList> shiftList(List<NameList> list){
        ShiftList nameList = new ShiftList(list);
        List<NameList> shiftList = nameList.getNameList();
        return shiftList;
    }
    public List<DayList> days(){
        List<DayList> days = appMapper.days();
        return days;
    }
    public String matchWorkId(int date){
        return appMapper.matchWorkId(date);
    }
    public String shiftPattern(int number){
        return appMapper.shiftPattern(number);
    }
    public void updateMethod(int date,String inputCode){
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
    public DayList convertList(DayList dayList){
        dayList.setVacationNameOne(convertMethod(dayList.getVacationNameOne()));
        dayList.setVacationNameTwo(convertMethod(dayList.getVacationNameTwo()));
        dayList.setVacationNameThree(convertMethod(dayList.getVacationNameThree()));
        dayList.setOverNameOne(convertMethod(dayList.getOverNameOne()));
        dayList.setOverNameTwo(convertMethod(dayList.getOverNameTwo()));
        dayList.setOverNameThree(convertMethod(dayList.getOverNameThree()));
        dayList.setEarlyNameOne(convertMethod(dayList.getEarlyNameOne()));
        dayList.setEarlyNameTwo(convertMethod(dayList.getEarlyNameTwo()));
        dayList.setEarlyNameThree(convertMethod(dayList.getEarlyNameThree()));
        return dayList;
    }
    public String convertMethod(String id){
        if(id != null){
            id = convertName(id);
        }
        return id;
    }
}
