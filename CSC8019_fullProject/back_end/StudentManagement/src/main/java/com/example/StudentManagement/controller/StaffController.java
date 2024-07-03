package com.example.StudentManagement.controller;

import com.example.StudentManagement.dao.StaffRepository;
import com.example.StudentManagement.dao.StudentRepository;
import com.example.StudentManagement.entity.*;
import com.example.StudentManagement.service.StaffService;
import com.example.StudentManagement.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StudentService stuService;
    @Resource
    private StudentRepository stuDao;
    @Resource
    private StaffService staffService;
    @Resource
    private StaffRepository staffRepository;

    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestBody Staff staff) {
        String result = staffService.login(staff);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/active")
    private ResponseEntity<String> active(@RequestBody Staff staff){
        String result = staffService.active(staff);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/forget")
    private ResponseEntity<String> forgetPasswd(@RequestBody Staff staff){
        String result = staffService.forgetPwd(staff);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @GetMapping("/getStaffInfo")
    public ResponseEntity<Staff> getStaffInfo(@RequestParam("username") String userID){
        Staff staff = staffRepository.findById(userID);
        if (staff==null){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        else {return new ResponseEntity<>(staff,HttpStatus.OK);}
    }


    //@CrossOrigin(origins = "http://localhost:63342",allowedHeaders = {"Content-Type", "application/json"})
    @GetMapping("/getStuDetail")
    public ResponseEntity<List<StudentDetail>> getStudentDetail(@RequestParam("SearchID") String studentID){
        //String studentID = "testUser1";
        //System.out.println(stuService.getStuDetail(studentID));
        return stuService.getStuDetail(studentID);
    }
    @GetMapping("/getStuInfo")
    public ResponseEntity<Student> getStudentInfo(@RequestParam("SearchID") String studentID){
        return stuService.getStuInfo(studentID);
    }

    @GetMapping("/getAssignedStuInfo")
    public ResponseEntity<List<Student>> getAssignedStuInfo(@RequestParam("username") String tutorID){
        return stuService.getAssignedStuInfo(tutorID);
    }

    @GetMapping("/getStuModule")
    public ResponseEntity<List<Grade>> getStudentModule(@RequestParam("searchID") String studentID){
        return stuService.getStuModule(studentID);
    }

    @PostMapping("/markCoursework")
    public ResponseEntity<String> markCoursework(@RequestBody Coursework coursework){
        return staffService.markCoursework(coursework);
    }
    public static class StudentDetail{
        private final String moduleCode;
        private final String assessmentType;
        private final String title;
        private final Integer assessmentGrade;
        public StudentDetail(String moduleCode,String assessmentType, String title,Integer asssessmentGrade){
            this.assessmentGrade = asssessmentGrade;
            this.moduleCode = moduleCode;
            this.title = title;
            this.assessmentType= assessmentType;
        }

        public String getModuleCode() {
            return moduleCode;
        }

        public String getTitle() {
            return title;
        }

        public Integer getAssessmentGrade() {
            return assessmentGrade;
        }

        public String getAssessmentType() {
            return assessmentType;
        }
    }


}
