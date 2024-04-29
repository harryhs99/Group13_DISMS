package com.example.StudentManagement.Service;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Entity.Absence;
import com.example.StudentManagement.Repository.StudentRepository;
import com.example.StudentManagement.Repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final AbsenceRepository absenceRepository; // 假设你有一个AbsenceRepository

    @Autowired
    public StudentService(StudentRepository studentRepository, AbsenceRepository absenceRepository) {
        this.studentRepository = studentRepository;
        this.absenceRepository = absenceRepository; // 初始化AbsenceRepository
    }

    @Transactional
    public Student createStudent(Student student) {
        // 创建学生逻辑
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        // 获取所有学生逻辑
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        // 获取指定学生逻辑
        return studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist."));
    }

    @Transactional
    public Student updateStudent(Long id, Student updatedStudent) {
        // 更新学生信息逻辑
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            studentRepository.save(student);
        } else {
            throw new IllegalStateException("Student with id " + id + " does not exist.");
        }
        return updatedStudent;
    }

    @Transactional
    public void deleteStudent(Long id) {
        // 删除学生逻辑
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Student with id " + id + " does not exist.");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public Absence notifyAbsence(Long studentId, Absence absence) {
        // 通知学生缺勤逻辑
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist.");
        }
        return absenceRepository.save(absence);
    }

    // 其他学生相关的服务方法...
}
