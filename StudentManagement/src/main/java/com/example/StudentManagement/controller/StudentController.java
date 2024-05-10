
package com.example.StudentManagement.controller;

import com.example.StudentManagement.entity.Staff;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @Description The StudentController class is responsible for handling HTTP requests related to student operations.
 * It uses the StudentService to perform operations such as login, activation, password recovery,
 * and fetching student and tutor information.
 * @author Shuyi Yang
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    /**
     * The StudentService instance that is autowired to this controller for handling student-related business logic.
     */
    @Resource
    private StudentService studentService;

    /**
     * Handles student login requests.
     *
     * @param student The student object containing login credentials.
     * @return A ResponseEntity indicating the login result.
     */
    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestBody Student student) {
        String result = studentService.login(student);
        if (result.equals("successfully")) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login failed");
    }

    /**
     * Activates a student account.
     *
     * @param student The student object containing activation details.
     * @return A ResponseEntity indicating the activation result.
     */
    @PostMapping("/active")
    public ResponseEntity<String> active(@RequestBody Student student) {
        String result = studentService.active(student);
        if (result.equals("successfully")) {
            return ResponseEntity.ok("Activation successful");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activation failed");
    }

    /**
     * Handles password recovery for a student.
     *
     * @param student The student object containing details for password recovery.
     * @return A ResponseEntity indicating the password recovery result.
     */
    @PostMapping("/forget")
    public ResponseEntity<String> forgetPasswd(@RequestBody Student student) {
        String result = studentService.forgetPwd(student);
        if (result.equals("successfully")) {
            return ResponseEntity.ok("Password recovery successful");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password recovery failed");
    }

    /**
     * Retrieves information for a specific student by their ID.
     *
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing the Student object if found, or a NOT_FOUND status.
     */
    @GetMapping("/getStuInfo")
    public ResponseEntity<Student> getStudentInfo(@RequestParam("studentID") String studentID) {
        return studentService.getStuInfo(studentID);
    }

    /**
     * Retrieves information for the tutor of a specific student by the student's ID.
     *
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing the Staff (tutor) object if found, or a NOT_FOUND status.
     */
    @GetMapping("/getTutorInfo")
    public ResponseEntity<Staff> getTutorInfo(@RequestParam("studentID") String studentID) {
        return studentService.getTutorInfo(studentID);
    }
}