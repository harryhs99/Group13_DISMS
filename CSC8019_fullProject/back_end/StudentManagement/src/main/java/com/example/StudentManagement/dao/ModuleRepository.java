package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Modules;
import com.example.StudentManagement.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;



@Repository
public interface ModuleRepository extends Mapper<Modules>{
//    @Select("select * from module where ModuleCode = #{moduleCode} limit 1")
//    Modules findByModuleCode(@Param("moduleCode") String moduleCode);
}

