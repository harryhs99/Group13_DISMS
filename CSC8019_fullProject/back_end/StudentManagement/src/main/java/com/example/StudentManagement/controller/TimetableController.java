package com.example.StudentManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/timetable")
public class TimetableController {
    @PostMapping("/timetableTest")
    public ResponseEntity<String> setTimetable(@RequestBody TestWeekTimetable testWeekTimetable){
        //System.out.println("test");
        //System.out.println(testWeekTimetable.getSlotID());
        //System.out.println(testWeekTimetable.getTimeTableData());
        //System.out.println(testWeekTimetable.getWeek());

        System.out.println(testWeekTimetable.getEventList().get(0).getContent());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getTimetableTest")
    public ResponseEntity<List<TestEvent>> getTimetable(
            @RequestParam("moduleCode") String moduleCode,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day){
        //System.out.println(moduleCode+mondayDate.toString());
        //construct a Date object
        LocalDate mondayDate = LocalDate.of(year,month,day);
        //System.out.println(localDate.toString());
        //System.out.println(moduleCode);
        List<TestEvent> testEventList = new ArrayList<>();
        testEventList.add(new TestEvent("1", "testCourse1\nUSB1007\nJohn"));
        testEventList.add(new TestEvent("3", "testCourse2\nUSB1008\nDan"));
        return new ResponseEntity<List<TestEvent>>(testEventList, HttpStatus.OK);
    }

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
    public static class TestWeekTimetable {
        private String moduleCode;
        private List<TestEvent> eventList;
        private String mondayDate;


        @Override
        public String toString() {
            String weekTimetableString=moduleCode+"@"+mondayDate+"@";
            for (TestEvent i :eventList
                 ) {
                weekTimetableString += i.toString();
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
