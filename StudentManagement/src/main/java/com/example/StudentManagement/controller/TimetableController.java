package com.example.StudentManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description This class provides a controller for handling timetable-related requests.
 * The whole timetable part is not complete
 * It has methods to set a timetable, get a timetable, and classes to represent a test event and a test week timetable.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@RestController
@CrossOrigin
@RequestMapping("/timetable")
public class TimetableController {
    /**
     * Set a timetable.
     * @param testWeekTimetable The timetable to be set.
     * @return A ResponseEntity indicating the status of the request.
     */
    @PostMapping("/timetableTest")
    public ResponseEntity<String> setTimetable(@RequestBody TestWeekTimetable testWeekTimetable){
        System.out.println(testWeekTimetable.getEventList().get(0).getContent());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Get a timetable.
     * @param moduleCode The code of the module.
     * @param year The year of the timetable.
     * @param month The month of the timetable.
     * @param day The day of the timetable.
     * @return A ResponseEntity containing the list of test events.
     */
    @GetMapping("/getTimetableTest")
    public ResponseEntity<List<TestEvent>> getTimetable(
            @RequestParam("moduleCode") String moduleCode,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day){
        LocalDate mondayDate = LocalDate.of(year,month,day);
        List<TestEvent> testEventList = new ArrayList<>();
        testEventList.add(new TestEvent("1", "testCourse1\nUSB1007\nJohn"));
        testEventList.add(new TestEvent("3", "testCourse2\nUSB1008\nDan"));
        return new ResponseEntity<List<TestEvent>>(testEventList, HttpStatus.OK);
    }

    /**
     * @Description This class represents a test event in the application.
     * It has properties to store event information such as slotID and content.
     */
    public static class TestEvent{
        private String slotID;
        private String content;

        public TestEvent(String slotID, String content){
            this.content = content;
            this.slotID = slotID;
        }

        @Override
        public String toString() {
            return slotID+"\n"+content+"#";
        }

        public String getContent() {
            return content;
        }

        public String getSlotID() {
            return slotID;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setSlotID(String slotID) {
            this.slotID = slotID;
        }
    }

    /**
     * @Description This class represents a timetable for a specific week in the application.
     * It has properties to store timetable information such as moduleCode, eventList, and mondayDate.
     */
    public static class TestWeekTimetable {
        private String moduleCode;
        private List<TestEvent> eventList;
        private String mondayDate;

        @Override
        public String toString() {
            String weekTimetableString=moduleCode+"@"+mondayDate+"\n";
            for (TestEvent i :eventList
            ) {
                weekTimetableString += i.toString()+",";
            }
            return weekTimetableString;
        }

        public String getModuleCode() {
            return moduleCode;
        }

        public void setEventList(List<TestEvent> eventList) {
            this.eventList = eventList;
        }

        public List<TestEvent> getEventList() {
            return eventList;
        }

        public String getMondayDate() {
            return mondayDate;
        }

        public void setModuleCode(String moduleCode) {
            this.moduleCode = moduleCode;
        }


        public void setMondayDate(String mondayDate) {
            this.mondayDate = mondayDate;
        }
    }
}
