package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.Teaching;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * @Description This interface provides a repository for the Teaching entity.
 * It extends the Mapper interface from MyBatis, providing basic CRUD operations.
 * Additional methods for complex queries can be added here.
 * @Author Yangcheng Liu
 * @Date 07/05/2024
 */
@Repository
public interface TeachingRepository extends Mapper<Teaching> {
}
