package com.example.StudentManagement.service;

import com.example.StudentManagement.controller.TimetableController;
import com.example.StudentManagement.dao.ModuleRepository;
import com.example.StudentManagement.entity.Modules;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
/**
 * @Description This class provides a service for managing timetables in the application.
 * The whole part is not complete
 * It has methods to set a timetable and get a week timetable from a string.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@Service
public class TimetableService {
    @Resource
    private ModuleRepository moduleRepository;
    /**
     * Set a timetable.
     * this part is not complete
     * @param testWeekTimetable The timetable to be set.
     * @return A ResponseEntity indicating the status of the request.
     */
    public ResponseEntity<String> setTimetable(TimetableController.TestWeekTimetable testWeekTimetable){
        Modules module = moduleRepository.selectByPrimaryKey(testWeekTimetable.getModuleCode());
        String curTimetable = module.getTimetable();
        if(curTimetable!=null){
//            String[] weekTimetable = curTimetable.split("#");
//            for (String i:weekTimetable
//                 ) {
//                String[] events = i.split("\n");
//            }
            curTimetable+= testWeekTimetable.toString();
        }
        else{
            curTimetable = testWeekTimetable.toString();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * Get a week timetable from a string.
     * this part is not complete
     * @param timetableString The string containing the timetable data.
     */
    public void getWeekTimetableFromString(String timetableString){
        //get the timetable string from the database
        //use split method to get data from the string
    }
}
