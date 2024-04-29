package com.example.StudentManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import com.example.StudentManagement.Entity.Exam;
import com.example.StudentManagement.Repository.ExamRepository;
import com.example.StudentManagement.Repository.StudentRepository;
import com.example.StudentManagement.Repository.ExamRegistrationRepository;
import com.example.StudentManagement.Repository.GradeRepository;
import com.example.StudentManagement.Repository.StaffRepository;
import com.example.StudentManagement.Entity.Staff;
import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Entity.ExamRegistration;
import com.example.StudentManagement.Entity.Grade;



@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final StudentRepository studentRepository;
    private final ExamRegistrationRepository examRegistrationRepository;
    private final GradeRepository gradeRepository;
    private final StaffRepository staffRepository; // 这里假设你有一个StaffRepository

    @Autowired
    public ExamService(ExamRepository examRepository, StudentRepository studentRepository,
                       ExamRegistrationRepository examRegistrationRepository,
                       GradeRepository gradeRepository, StaffRepository staffRepository) {
        this.examRepository = examRepository;
        this.studentRepository = studentRepository;
        this.examRegistrationRepository = examRegistrationRepository;
        this.gradeRepository = gradeRepository;
        this.staffRepository = staffRepository;
    }

    // 创建考试
    @Transactional
    public void createExam(Exam exam, Long staffId) {
        Staff staff = staffRepository.findById(staffId).orElseThrow(() ->
                new IllegalArgumentException("Staff not found with ID: " + staffId));
        exam.setCreator(staff);
        examRepository.save(exam);
        System.out.println("Exam created with ID: " + exam.getId());
    }

    // 学生注册考试
    @Transactional
    public void registerStudentForExam(Long studentId, Long examId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalArgumentException("Student not found with ID: " + studentId));
        Exam exam = examRepository.findById(examId).orElseThrow(() ->
                new IllegalArgumentException("Exam not found with ID: " + examId));
        ExamRegistration registration = new ExamRegistration(student, exam, LocalDateTime.now());
        examRegistrationRepository.save(registration);
        System.out.println("Student " + student.getName() + " registered for exam " + exam.getName());
    }

    // 为学生考试打分
    @Transactional
    public void gradeStudentExam(Long examRegistrationId, double score) {
        ExamRegistration registration = examRegistrationRepository.findById(examRegistrationId).orElseThrow(() ->
                new IllegalArgumentException("Exam registration not found with ID: " + examRegistrationId));
        Grade grade = new Grade(registration, score);
        gradeRepository.save(grade);
        System.out.println("Grade recorded for student: " + registration.getStudent().getName());
    }
}
