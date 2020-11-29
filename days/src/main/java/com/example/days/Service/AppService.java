package com.example.days.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.DayList;
import com.example.days.domain.DayMarge;
import com.example.days.domain.NameList;
import com.example.days.domain.ShiftList;
import com.example.days.domain.ShiftMarge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppService {
    
    @Autowired
    AppMapper am;

    

    public List<NameList> nameListAll(){
        List<NameList> list = am.listAll();
        return list;
    }
    public List<NameList> listOne(String shift){
        List<NameList> listOne = am.listOne(shift);
        return listOne;
    }
    
    public List<DayList> days(){
        List<DayList> days = am.days();
        return days;
    }
    public List<NameList> shiftList(List<NameList> list){
        ShiftList nameList = new ShiftList(list);
        List<NameList> shiftList = nameList.getNameList();
        return shiftList;
    }
    public String matchWorkId(int date){
        return am.matchWorkId(date);
    }
    public String shiftPattern(int number){
        return am.shiftPattern(number);
    }
    public void updateMethod(int date,String shiftCode){
        //シフトパターンNoが決定
        int countNumber = am.number(shiftCode);
        //intが４の場合,
        //スケジュールの日数だけくり返す
        for(int i = date ; i <= 30 ; i++){
            //一斉休暇日"9999"の場合はスキップする
            if(am.matchWorkId(i).equals("9999")){
                continue;
            }
            //シフトパターンが入る"3214"etc ナンバーで指定
            String shiftPattern = shiftPattern(countNumber);
            am.updateWorkId(shiftPattern,i);
            countNumber++;
            if(countNumber == 21){
                countNumber = 1;
            }
        }
        
        
        
        
        //最終処理
        
    }
    public void ppa(){
        am.updateWorkId("4321",1);
    }
}
