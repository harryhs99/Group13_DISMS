package com.example.StudentManagement.service;

import com.example.StudentManagement.controller.StaffController;
import com.example.StudentManagement.dao.*;
import com.example.StudentManagement.entity.*;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description This class provides a service for managing students in the application.
 * It has methods to login, activate an account, forget password, get student detail, get student info, get tutor info, get student module, and get assigned student info.
 * @author Shuyi Yang
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@Service
public class StudentService {
    @Resource
    private StudentRepository studentDao;
    @Resource
    private ExamRepository examDao;
    @Resource
    private CourseworkRepository courseworkRepository;
    @Resource
    private GradeRepository gradeRepository;
    @Resource
    private StaffRepository staffRepository;

    /**
     * Service method to handle the login process for a student.
     * @param student The student object containing the login credentials.
     * @return A String result indicating the status of the login attempt.
     */
    public String login(Student student) {
        Student databaseStudent = studentDao.findById(student.getUserID());
        if (databaseStudent == null) {
            // If no student is found with the provided user ID, return an error message.
            return "this account doesn't exist or not Student account";
        }
        if (databaseStudent.getUserPassword() == null || databaseStudent.getUserPassword().isEmpty()) {
            // If the student's password is null or empty, the account needs to be activated first.
            return "this account need be actived";
        }
        if (!Objects.equals(student.getUserPassword(), databaseStudent.getUserPassword())) {
            // If the provided password does not match the one in the database, return a password error.
            return "passwd error";
        }
        // If all checks pass, return a successful login message.
        return "successfully";
    }

    /**
     * Service method to activate a student's account.
     * @param student The student object containing the user ID for activation.
     * @return A String result indicating the status of the activation process.
     */
    public String active(Student student) {
        // Find the student by their user ID in the database.
        Student activeStudent = studentDao.findById(student.getUserID());
        // Check if the student exists in the database.
        if (activeStudent != null) {
            // If the account has not been activated (password is null or empty), set the initial password.
            if ("".equals(activeStudent.getUserPassword()) || activeStudent.getUserPassword() == null) {
                studentDao.updatePassword(activeStudent.getUserID(), activeStudent.initialPasswd());
                return "successfully";
            }
            // If the account has already been activated, return a message indicating so.
            return "this account has already been actived";
        }
        // If the student does not exist, return a message indicating the account does not exist.
        return "doesn't exist this account";
    }

    /**
     * Service method to handle a password reset (forget password) for a student.
     * @param student The student object containing the user ID and the new password.
     * @return A String result indicating the status of the password reset process.
     */
    public String forgetPwd(Student student) {
        if (student.getUserPassword().length() > 8) {
            // If the new password is longer than 8 characters, return a message indicating so.
            return "Passwd over 8 length";
        }
        Student databaseStudent = studentDao.findById(student.getUserID());
        if (databaseStudent == null) {
            // If no student is found with the provided user ID, return an account not found message.
            return "Don't have this account";
        }
        if (databaseStudent.getUserPassword() == null || databaseStudent.getUserPassword().isEmpty()) {
            // If the student's account needs to be activated, return an account activation message.
            return "Your account need to be actived";
        }
        if (databaseStudent.getUserPassword().equals(student.getUserPassword())) {
            // If the new password is the same as the current one, return a message indicating the password cannot be the same.
            return "Your new password cannot be the same as your current password";
        }
        // If all checks pass, update the student's password with the new one.
        studentDao.updatePassword(student.getUserID(), student.getUserPassword());
        return "successfully";
    }

    /**
     * Service method to get the details of a student.
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing the list of student details.
     */
    public ResponseEntity<List<StaffController.StudentDetail>> getStuDetail(String studentID){
        List<Exam> examList =  examDao.findExamByStudentID(studentID);
        List<Coursework> courseworkList = courseworkRepository.findCourseworkByStudentID(studentID);
        List<StaffController.StudentDetail> studentDetailList = new ArrayList<>(examList.size()+courseworkList.size());
        for (Exam i : examList) {
            studentDetailList.add(new StaffController.StudentDetail(
                    i.getModuleCode(),"Exam",i.getTitle(),i.getGrade()));
        }
        for (Coursework i : courseworkList) {
            studentDetailList.add(new StaffController.StudentDetail(
                    i.getModuleCode(),"Coursework",i.getTitle(),i.getGrade()));
        }
        if (studentDetailList.isEmpty()){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        else {
            return new ResponseEntity<List<StaffController.StudentDetail>>(studentDetailList,HttpStatus.OK);}
    }

    /**
     * Service method to get the information of a student.
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing the student information.
     */
    public ResponseEntity<Student> getStuInfo(String studentID){
        Student testStudent= studentDao.findByStudentId(studentID);
        if(testStudent!=null){
            return new ResponseEntity<Student>(testStudent, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Service method to get the information of a tutor.
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing the tutor information.
     */
    public ResponseEntity<Staff> getTutorInfo(String studentID){
        Student curStudent = studentDao.findByStudentId(studentID);
        Staff tutor = staffRepository.findById(curStudent.getTutor());
        if(tutor !=null){
            return new ResponseEntity<Staff>(tutor, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Service method to get the module of a student.
     * @param studentID The ID of the student.
     * @return A ResponseEntity containing the list of grades.
     */
    public ResponseEntity<List<Grade>> getStuModule(String studentID){
        List<Grade> stuModuleList = gradeRepository.findByStudentId(studentID);
        if(stuModuleList!=null){
            return new ResponseEntity<List<Grade>>(stuModuleList, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Service method to get the information of assigned students.
     * @param tutorID The ID of the tutor.
     * @return A ResponseEntity containing the list of students.
     */
    public ResponseEntity<List<Student>> getAssignedStuInfo(String tutorID){
        List<Student> assignedStuList = studentDao.findByTutor(tutorID);
        return new ResponseEntity<List<Student>>(assignedStuList, HttpStatus.OK);
    }
}
