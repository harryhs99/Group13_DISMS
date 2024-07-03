package com.example.StudentManagement.controller;

import com.example.StudentManagement.entity.Staff;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;


    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestBody Student student) {
        String result = studentService.login(student);
        if (result.equals("successfully")) {
            return ResponseEntity.ok("result");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/active")
    private ResponseEntity<String> active(@RequestBody Student student){
        String result = studentService.active(student);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @PostMapping("/forget")
    private ResponseEntity<String> forgetPasswd(@RequestBody Student student){
        System.out.println(student.getUserID());
        String result = studentService.forgetPwd(student);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @GetMapping("/getStuInfo")
    public ResponseEntity<Student> getStudentInfo(@RequestParam("studentID") String studentID){
        //System.out.println(studentID);
        return studentService.getStuInfo(studentID);
    }

    @GetMapping("/getTutorInfo")
    public ResponseEntity<Staff> getTutorInfo(@RequestParam("studentID") String studentID){
        //System.out.println(studentID);
        return studentService.getTutorInfo(studentID);
    }

}
