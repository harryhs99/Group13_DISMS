package com.example.StudentManagement.service;

import com.example.StudentManagement.controller.TimetableController;
import com.example.StudentManagement.dao.ModuleRepository;
import com.example.StudentManagement.entity.Modules;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {
    @Resource
    private ModuleRepository moduleRepository;
    public ResponseEntity<String> setTimetable(TimetableController.TestWeekTimetable testWeekTimetable){
        Modules module = moduleRepository.selectByPrimaryKey(testWeekTimetable.getModuleCode());
        String curTimetable = module.getTimetable();
        if(curTimetable!=null){

        }
        return null;
    }

    public void getWeekTimetableFromString(String timetableString){
        
    }
}
