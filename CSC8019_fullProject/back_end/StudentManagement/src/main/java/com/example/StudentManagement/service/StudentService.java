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

@Service
public class StudentService {
    @Resource
    private StudentRepository studentDao;
    @Resource
    private ExamRepository examDao;
    @Resource
    private CourseworkRepository courseworkRepository;
    @Resource
    private TeachingRepository teachingRepository;
    @Resource
    private GradeRepository gradeRepository;
    @Resource
    private StaffRepository staffRepository;

    public String login(Student student) {
        Student databaseStudent = studentDao.findById(student.getUserID());
        if (databaseStudent == null){
            return "this account doesn't exist or not Student account";
        }
        if (databaseStudent.getUserPassword() == null || databaseStudent.getUserPassword().isEmpty()){
            return "this account need be actived";
        }
        if (!Objects.equals(student.getUserPassword(), databaseStudent.getUserPassword())){
            return "passwd error";
        }
        return "successfully";
    }

    public String active(Student student) {
        //find student
        Student activeStudent = studentDao.findById(student.getUserID());
        // check student if exist
        if (activeStudent != null ){
            // check if account been actived
            if("".equals(activeStudent.getUserPassword()) || activeStudent.getUserPassword() == null){
                studentDao.updatePassword(activeStudent.getUserID(),activeStudent.initialPasswd());
                return "successfully";
            }
            return "this account has already been actived";
        }
        return "doesn't exist this account";
    }

    public String forgetPwd(Student student) {
        if (student.getUserPassword().length() > 8) {
            return "Passwd over 8 length";
        }
        Student databaseStudent = studentDao.findById(student.getUserID());
        if (databaseStudent == null ){
            return "Don't have this account";
        }
        if (databaseStudent.getUserPassword() == null || databaseStudent.getUserPassword().isEmpty()){
            return "Your account need to be actived";
        }
        if (databaseStudent.getUserPassword().equals(student.getUserPassword())){
            return "Your new password cannot be the same as your current password";
        }
        studentDao.updatePassword(student.getUserID(), student.getUserPassword());
        return "successfully";
    }

    public ResponseEntity<List<StaffController.StudentDetail>> getStuDetail(String studentID){
        //StaffController.StudentDetail stuDetail = new StaffController.StudentDetail();
        List<Exam> examList =  examDao.findExamByStudentID(studentID);
        List<Coursework> courseworkList = courseworkRepository.findCourseworkByStudentID(studentID);
        List<StaffController.StudentDetail> studentDetailList = new ArrayList<>(examList.size()+courseworkList.size());
        int count = 0;
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

    public ResponseEntity<Student> getStuInfo(String studentID){
        Student testStudent= studentDao.findByStudentId(studentID);
        if(testStudent!=null){
            return new ResponseEntity<Student>(testStudent, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

    public ResponseEntity<List<Grade>> getStuModule(String studentID){
        List<Grade> stuModuleList = gradeRepository.findByStudentId(studentID);
//        System.out.println(stuModuleList.get(0).getModuleCode());
        if(stuModuleList!=null){
            return new ResponseEntity<List<Grade>>(stuModuleList, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Student>> getAssignedStuInfo(String tutorID){
        List<Student> assignedStuList = studentDao.findByTutor(tutorID);
        return new ResponseEntity<List<Student>>(assignedStuList, HttpStatus.OK);
    }
}
