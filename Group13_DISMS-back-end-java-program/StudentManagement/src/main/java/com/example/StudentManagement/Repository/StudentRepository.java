package com.example.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudentManagement.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // 这里可以添加特定的查询方法，如根据邮箱查询学生等
}

