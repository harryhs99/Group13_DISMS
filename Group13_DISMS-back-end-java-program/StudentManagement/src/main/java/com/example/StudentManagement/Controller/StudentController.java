package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.StudentManagement.DTO.AbsenceRequest;
import com.example.StudentManagement.Entity.Absence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 创建学生
    @PostMapping("/")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // 获取所有学生
    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 获取指定学生
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // 更新学生信息
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // 删除学生
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // 学生缺席通知
    @PostMapping("/{id}/absence")
    public Absence notifyAbsence(@PathVariable Long id, @RequestBody AbsenceRequest absenceRequest) {
        LocalDate startDate = LocalDate.parse(absenceRequest.getStartDate());
        LocalDate endDate = LocalDate.parse(absenceRequest.getEndDate());
        LocalTime startTime = LocalTime.parse(absenceRequest.getStartTime());
        LocalTime endTime = LocalTime.parse(absenceRequest.getEndTime());

        Absence absence = new Absence();
        absence.setStudentId(id);
        absence.setReason(absenceRequest.getReason());
        absence.setStartDate(startDate);
        absence.setEndDate(endDate);
        absence.setStartTime(startTime);
        absence.setEndTime(endTime);
        absence.setDescription(absenceRequest.getDescription());

        return studentService.notifyAbsence(id, absence);
    }


}
