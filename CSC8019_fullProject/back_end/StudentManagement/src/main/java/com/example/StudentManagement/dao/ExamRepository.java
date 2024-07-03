package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ExamRepository extends Mapper<Exam> {

    @Select("select * from exam where StudentID = #{StudentID}")
    List<Exam> findExamByStudentID(@Param("StudentID") String studentID);
}

