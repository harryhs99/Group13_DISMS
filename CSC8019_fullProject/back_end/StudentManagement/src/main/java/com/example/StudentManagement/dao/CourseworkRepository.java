package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Coursework;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseworkRepository extends Mapper<Coursework>{
    @Select("select * from coursework where StudentID = #{StudentID}")
    List<Coursework> findCourseworkByStudentID(@Param("StudentID") String studentID);

}
