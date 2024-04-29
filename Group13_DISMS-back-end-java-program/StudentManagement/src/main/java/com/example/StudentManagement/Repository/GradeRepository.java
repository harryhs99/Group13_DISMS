package com.example.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudentManagement.Entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    // 可以添加特定的查询方法，如根据考试注册记录查询成绩等
}
