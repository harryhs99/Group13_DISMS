package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description This interface provides a repository for the Exam entity.
 * It extends the Mapper interface from MyBatis, providing basic CRUD operations.
 * Additional methods for complex queries can be added here.
 * @Author Yangcheng Liu
 * @Date 07/05/2024
 */
@Repository
public interface ExamRepository extends Mapper<Exam> {

    /**
     * Find exams by student ID.
     * @param studentID The ID of the student.
     * @return A list of exams for the student.
     */
    @Select("select * from exam where StudentID = #{StudentID}")
    List<Exam> findExamByStudentID(@Param("StudentID") String studentID);
}
