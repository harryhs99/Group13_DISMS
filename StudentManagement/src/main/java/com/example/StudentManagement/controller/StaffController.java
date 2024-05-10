
package com.example.StudentManagement.controller;

import com.example.StudentManagement.dao.StaffRepository;
import com.example.StudentManagement.entity.*;
import com.example.StudentManagement.service.StaffService;
import com.example.StudentManagement.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description The StaffController class is responsible for handling HTTP requests related to staff operations.
 *  It uses services and repositories to perform operations such as login, activation, password recovery,
 *  and fetching staff and student information.
 * @author Shuyi Yang
 * @author Yangcheng Liu
 * @date 07/05/2024
 */
@RestController
@CrossOrigin
@RequestMapping("/staff")
public class StaffController {
    // Dependency injection for student service and repository
    @Resource
    private StudentService stuService;
    // Dependency injection for staff service and repository
    @Resource
    private StaffService staffService;
    @Resource
    private StaffRepository staffRepository;

    /**
     * Handles staff login requests.
     *
     * @param staff The staff object containing login credentials.
     * @return A ResponseEntity indicating the login result.
     */
    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestBody Staff staff) {
        String result = staffService.login(staff);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    /**
     * Activates a staff account.
     *
     * @param staff The staff object containing activation details.
     * @return A ResponseEntity indicating the activation result.
     */
    @PostMapping("/active")
    private ResponseEntity<String> active(@RequestBody Staff staff) {
        String result = staffService.active(staff);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    /**
     * Handles password recovery for staff.
     *
     * @param staff The staff object containing details for password recovery.
     * @return A ResponseEntity indicating the password recovery result.
     */
    @PostMapping("/forget")
    private ResponseEntity<String> forgetPasswd(@RequestBody Staff staff) {
        String result = staffService.forgetPwd(staff);
        if (result.equals("successfully")) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    /**
     * Retrieves information for a specific staff member by their username.
     *
     * @param userID The username of the staff member.
     * @return A ResponseEntity containing the staff information if found, or a NOT_FOUND status.
     */
    @GetMapping("/getStaffInfo")
    public ResponseEntity<Staff> getStaffInfo(@RequestParam("username") String userID) {
        Staff staff = staffRepository.findById(userID);
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }
    }

    /**
     * Retrieves detailed information about a student by their ID.
     *
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing a list of StudentDetail objects.
     */
    @GetMapping("/getStuDetail")
    public ResponseEntity<List<StudentDetail>> getStudentDetail(@RequestParam("SearchID") String studentID) {
        return stuService.getStuDetail(studentID);
    }

    /**
     * Retrieves basic information about a student by their ID.
     *
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing the Student object.
     */
    @GetMapping("/getStuInfo")
    public ResponseEntity<Student> getStudentInfo(@RequestParam("SearchID") String studentID) {
        return stuService.getStuInfo(studentID);
    }

    /**
     * Retrieves a list of students assigned to a specific tutor by their tutor ID.
     *
     * @param tutorID The ID of the tutor.
     * @return A ResponseEntity containing a list of Student objects.
     */
    @GetMapping("/getAssignedStuInfo")
    public ResponseEntity<List<Student>> getAssignedStuInfo(@RequestParam("username") String tutorID) {
        return stuService.getAssignedStuInfo(tutorID);
    }

    /**
     * Retrieves the modules and grades for a student by their ID.
     *
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing a list of Grade objects.
     */
    @GetMapping("/getStuModule")
    public ResponseEntity<List<Grade>> getStudentModule(@RequestParam("searchID") String studentID) {
        return stuService.getStuModule(studentID);
    }

    /**
     * Marks a coursework grade for a student.
     *
     * @param coursework The Coursework object containing details of the coursework to be marked.
     * @return A ResponseEntity indicating the result of marking the coursework.
     */
    @PostMapping("/markCoursework")
    public ResponseEntity<String> markCoursework(@RequestBody Coursework coursework) {
        return staffService.markCoursework(coursework);
    }

    /**
     * A nested static class representing the detailed information of a student's assessment.
     */
    public static class StudentDetail {
        private final String moduleCode;
        private final String assessmentType;
        private final String title;
        private final Integer assessmentGrade;

        public StudentDetail(String moduleCode, String assessmentType, String title, Integer assessmentGrade) {
            this.moduleCode = moduleCode;
            this.assessmentType = assessmentType;
            this.title = title;
            this.assessmentGrade = assessmentGrade;
        }

        /**
         * Gets the module code of the assessment.
         *
         * @return The module code as a String.
         */
        public String getModuleCode() {
            return moduleCode;
        }

        /**
         * Gets the title of the assessment.
         *
         * @return The title as a String.
         */
        public String getTitle() {
            return title;
        }

        /**
         * Gets the grade of the assessment.
         *
         * @return The grade as an Integer.
         */
        public Integer getAssessmentGrade() {
            return assessmentGrade;
        }

        /**
         * Gets the type of the assessment.
         *
         * @return The assessment type as a String.
         */
        public String getAssessmentType() {
            return assessmentType;
        }
    }
}