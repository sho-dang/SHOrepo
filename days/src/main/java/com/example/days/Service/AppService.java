package com.example.days.Service;

import java.util.List;

import com.example.days.Mapper.AppMapper;
import com.example.days.domain.NameList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppService {
    
    @Autowired
    AppMapper am;

    public List<NameList> nameList(){
        List<NameList> list = am.list();
        return list;
    }
    public List<NameList> listOne(String shift){
        List<NameList> listOne = am.listOne(shift);
        return listOne;
    }

}
