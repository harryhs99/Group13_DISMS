package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Coursework;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description This interface provides a repository for the Coursework entity.
 * It extends the Mapper interface from MyBatis, providing basic CRUD operations.
 * Additional methods for complex queries can be added here.
 * @Author Yangcheng Liu
 * @Date 07/05/2024
 */
@Repository
public interface CourseworkRepository extends Mapper<Coursework>{
    /**
     * Find coursework by student ID.
     * @param studentID The ID of the student.
     * @return A list of coursework for the student.
     */
    @Select("select * from coursework where StudentID = #{StudentID}")
    List<Coursework> findCourseworkByStudentID(@Param("StudentID") String studentID);
}
