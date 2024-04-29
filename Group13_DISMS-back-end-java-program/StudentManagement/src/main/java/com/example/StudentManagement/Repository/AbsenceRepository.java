package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    // 在这里根据需要添加更多的自定义查询方法。

}

