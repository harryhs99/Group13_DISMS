package com.example.StudentManagement;

import com.example.StudentManagement.dao.CourseworkRepository;
import com.example.StudentManagement.dao.ExamRepository;
import com.example.StudentManagement.dao.StudentRepository;
import com.example.StudentManagement.entity.Coursework;
import com.example.StudentManagement.entity.Exam;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.controller.StaffController.StudentDetail;
import com.example.StudentManagement.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
/**
 * @Description This class is a unit test class for StudentService, used to test the methods in StudentService.
 * @Author Yangcheng Liu
 * @Date 07/05/2024
 */
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentDao;

    @Mock
    private ExamRepository examDao;

    @Mock
    private CourseworkRepository courseworkRepository;
    /**
     * @Description Initializes mock objects before each test method is executed.
     */
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    /**
     * @Description Tests the login method in StudentService.
     */
    @Test
    public void testLogin() {
        Student student = new Student();
        student.setUserID("stu01");
        student.setUserPassword("123456");
        Student databaseStudent = new Student();
        databaseStudent.setUserID("stu01");
        databaseStudent.setUserPassword("123456");
        when(studentDao.findById("stu01")).thenReturn(databaseStudent);
        String result = studentService.login(student);
        assertEquals("successfully", result);
    }
    /**
     * @Description Tests the getStuDetail method in StudentService.
     */
    @Test
    public void testGetStuDetail() {
        String studentID = "testUser";
        //
        Exam exam = new Exam();
        exam.setModuleCode("module1");
        exam.setTitle("title1");
        exam.setGrade(90);
        //
        Coursework coursework = new Coursework();
        coursework.setModuleCode("module2");
        coursework.setTitle("title2");
        coursework.setGrade(85);

        List<Exam> examList = Arrays.asList(exam);
        List<Coursework> courseworkList = Arrays.asList(coursework);

        when(examDao.findExamByStudentID(studentID)).thenReturn(examList);
        when(courseworkRepository.findCourseworkByStudentID(studentID)).thenReturn(courseworkList);

        ResponseEntity<List<StudentDetail>> result = studentService.getStuDetail(studentID);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(2, result.getBody().size());
        assertEquals("module1", result.getBody().get(0).getModuleCode());
        assertEquals("module2", result.getBody().get(1).getModuleCode());
    }
}
