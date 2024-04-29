package com.example.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StudentManagement.Entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    // 这里可以添加特定的查询方法，如根据名称查询考试等
}
