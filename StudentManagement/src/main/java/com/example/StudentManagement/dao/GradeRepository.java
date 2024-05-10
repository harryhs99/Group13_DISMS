package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Grade;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.Teaching;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description This interface provides a repository for the Grade entity.
 * It extends the Mapper interface from MyBatis, providing basic CRUD operations.
 * Additional methods for complex queries can be added here.
 * @Author Yangcheng Liu
 * @Date 07/05/2024
 */
public interface GradeRepository extends Mapper<Grade> {
    /**
     * Find grades by student ID.
     * @param studentID The ID of the student.
     * @return A list of grades for the student.
     */
    @Select("select * from grade where StudentID = #{studentID}")
    List<Grade> findByStudentId(@Param("studentID") String studentID);
}
