package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    // 这里可以添加自定义的查询方法
}
