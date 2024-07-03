package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.Teaching;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface TeachingRepository extends Mapper<Teaching> {
//    @Select("select * from Teaching where userID = #{UserID}")
//    List<Teaching> findByStudentId(@Param("UserID") String userID);
}
