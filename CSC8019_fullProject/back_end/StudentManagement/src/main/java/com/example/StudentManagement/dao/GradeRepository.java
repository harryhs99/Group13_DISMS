package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Grade;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.Teaching;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GradeRepository extends Mapper<Grade> {
    @Select("select * from grade where StudentID = #{studentID}")
    List<Grade> findByStudentId(@Param("studentID") String studentID);
}
