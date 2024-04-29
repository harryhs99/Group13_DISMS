package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Entity.ExamRegistration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRegistrationRepository extends JpaRepository<ExamRegistration, Long> {
    // 可以添加特定的查询方法，如根据学生和考试查询注册记录等
}

