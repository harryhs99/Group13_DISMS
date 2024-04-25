package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Params;
import com.example.StudentManagement.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserRepository extends Mapper<User> {

    @Select("select * from user where userID = #{userID} limit 1")
    User findById(@Param("userID") String userID);

//    @Select("SELECT * FROM user WHERE userID = #{params.userID} AND telephone = #{params.telephone}")
    List<User> findBySearch(@Param("params") Params params);


}
