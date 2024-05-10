package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Modules;
import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Description This interface provides a repository for the Modules entity.
 * It extends the Mapper interface from MyBatis, providing basic CRUD operations.
 * Additional methods for complex queries can be added here.
 * @Author Yangcheng Liu
 * @Date 07/05/2024
 */
@Repository
public interface ModuleRepository extends Mapper<Modules>{
}

