package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.StudentManagement.Entity.Exam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam, @RequestParam Long staffId) {
        examService.createExam(exam, staffId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
