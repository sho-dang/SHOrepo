package com.example.days.Service;

import java.util.List;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.Day.DayList;
import com.example.days.domain.NameList.NameList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AppService {
    
    @Autowired
    AppMapper appMapper;


    /**
     * 
     * @param shiftテーブル
     */

    public List<NameList> nameListAll(){ //test済み
        List<NameList> list = appMapper.listAll();
        return list;
    }
    public List<NameList> listOne(String shiftName){ //test済み
        List<NameList> listOne = appMapper.listOne(shiftName);
        return listOne;
    }
    public String convertName(String id){ //test済み
        String convertName = appMapper.convertName(id);
        return convertName;
    }
    public String convertId(String nameList){ //test済み
        String convertId = appMapper.convertId(nameList);
        return convertId;
    }
    /*
    public List<NameList> shiftList(List<NameList> list){ //test済み
        ShiftList nameList = new ShiftList(list);
        List<NameList> shiftList = nameList.getNameList();
        return shiftList;
    }
    */
    public void insertName(NameList nameList){ //test済み
        appMapper.insertName(nameList.getId(), nameList.getNameList(), nameList.getShiftName());
    }
    public void deleteName(String id){ //test済み
        appMapper.deleteName(id);
    }

    public DayList convertToNameList(DayList dayList){ //test済み
        dayList.setVacationNameOne(convertToNameMethod(dayList.getVacationNameOne()));
        dayList.setVacationNameTwo(convertToNameMethod(dayList.getVacationNameTwo()));
        dayList.setVacationNameThree(convertToNameMethod(dayList.getVacationNameThree()));
        dayList.setOverNameOne(convertToNameMethod(dayList.getOverNameOne()));
        dayList.setOverNameTwo(convertToNameMethod(dayList.getOverNameTwo()));
        dayList.setOverNameThree(convertToNameMethod(dayList.getOverNameThree()));
        dayList.setEarlyNameOne(convertToNameMethod(dayList.getEarlyNameOne()));
        dayList.setEarlyNameTwo(convertToNameMethod(dayList.getEarlyNameTwo()));
        dayList.setEarlyNameThree(convertToNameMethod(dayList.getEarlyNameThree()));
        return dayList;
    }
    public String convertToNameMethod(String id){ //test済み
        if(id != null){
            id = convertName(id);
        }
        return id;
    }
    @Transactional
    public DayList convertToIdList(DayList dayList){ //test済み
        dayList.setVacationNameOne(convertToIdMethod(dayList.getVacationNameOne()));
        dayList.setVacationNameTwo(convertToIdMethod(dayList.getVacationNameTwo()));
        dayList.setVacationNameThree(convertToIdMethod(dayList.getVacationNameThree()));
        dayList.setOverNameOne(convertToIdMethod(dayList.getOverNameOne()));
        dayList.setOverNameTwo(convertToIdMethod(dayList.getOverNameTwo()));
        dayList.setOverNameThree(convertToIdMethod(dayList.getOverNameThree()));
        dayList.setEarlyNameOne(convertToIdMethod(dayList.getEarlyNameOne()));
        dayList.setEarlyNameTwo(convertToIdMethod(dayList.getEarlyNameTwo()));
        dayList.setEarlyNameThree(convertToIdMethod(dayList.getEarlyNameThree()));
        return dayList;
    }
    public String convertToIdMethod(String nameList){ //test済み
        if(nameList == null){
            nameList = "";
        }
        if(nameList.isEmpty()){
            nameList = "XX";
        }else{
            nameList = convertId(nameList);
        };
        return nameList;
    }

    /**
     * @param scheduleテーブル
     */

    public List<DayList> days(){ //test済み
        List<DayList> days = appMapper.days();
        return days;
    }
    public DayList selectDayList(int date){
        DayList selectDayList = appMapper.selectDayList(date);
        return selectDayList;
    }
    public String matchWorkId(int date){ //test済み
        return appMapper.matchWorkId(date);
    }
    
    public void updateWorkId(int date,String inputCode){ //test済み
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
    public void updateAllVacation(int date){
        String vacationWorkId = "9999";
        appMapper.updateWorkId(vacationWorkId, date);
    }
    public void deleteAllVacation(int date){
        String resetWorkId = "0000";
        appMapper.updateWorkId(resetWorkId, date);
    }


    /**
     * @param shiftpatternテーブル
     */

    public String shiftPattern(int number){ //test済み
        return appMapper.shiftPattern(number);
    }

    
    
    //入力値判定メソッド
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

    @Transactional //NULLを空文字に変換
    public DayList convertNullEmpty(DayList dayList){
        dayList.setVacationNameOne(convertNullEmptyMethod(dayList.getVacationNameOne()));
        dayList.setVacationNameTwo(convertNullEmptyMethod(dayList.getVacationNameTwo()));
        dayList.setVacationNameThree(convertNullEmptyMethod(dayList.getVacationNameThree()));
        dayList.setOverNameOne(convertNullEmptyMethod(dayList.getOverNameOne()));
        dayList.setOverNameTwo(convertNullEmptyMethod(dayList.getOverNameTwo()));
        dayList.setOverNameThree(convertNullEmptyMethod(dayList.getOverNameThree()));
        dayList.setEarlyNameOne(convertNullEmptyMethod(dayList.getEarlyNameOne()));
        dayList.setEarlyNameTwo(convertNullEmptyMethod(dayList.getEarlyNameTwo()));
        dayList.setEarlyNameThree(convertNullEmptyMethod(dayList.getEarlyNameThree()));
        return dayList;
    }   //NULLを空文字に変換
    public String convertNullEmptyMethod(String string){
        if(string == null){
            string = "";
        }
        if(string.isEmpty()){
            string = "XX";
        }else{};
        return string;
    }
    
    //既存のscheduleデータを更新するメソッド
    public DayList convertDayList(DayList newDayList,DayList sourceDayList){
        switch(shiftInData(sourceDayList)){
            case "1":
            newDayList.setVacationNameOne(sourceDayList.getVacationNameOne());
            newDayList.setOverNameOne(sourceDayList.getOverNameOne());
            newDayList.setEarlyNameOne(sourceDayList.getEarlyNameOne());
            break;
            case "2":
            newDayList.setVacationNameTwo(sourceDayList.getVacationNameTwo());
            newDayList.setOverNameTwo(sourceDayList.getOverNameTwo());
            newDayList.setEarlyNameTwo(sourceDayList.getEarlyNameTwo());
            break;
            case "3":
            newDayList.setVacationNameThree(sourceDayList.getVacationNameThree());
            newDayList.setOverNameThree(sourceDayList.getOverNameThree());
            newDayList.setEarlyNameThree(sourceDayList.getEarlyNameThree());
            break;
        }
        return newDayList;
    }
    //変更後のvacationCodeを連結
    public String linkNewVacationCode(DayList sourceDayList){
        sourceDayList.setVacationCode(
            "1" + sourceDayList.getVacationNameOne() + sourceDayList.getOverNameOne() + sourceDayList.getEarlyNameOne() +
            "2" + sourceDayList.getVacationNameTwo() + sourceDayList.getOverNameTwo() + sourceDayList.getEarlyNameTwo() +
            "3" + sourceDayList.getVacationNameThree() + sourceDayList.getOverNameThree() + sourceDayList.getEarlyNameThree()
            );
        return sourceDayList.getVacationCode();
    }
    
}
