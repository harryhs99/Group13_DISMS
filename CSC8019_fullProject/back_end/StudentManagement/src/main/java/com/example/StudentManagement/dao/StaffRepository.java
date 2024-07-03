package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface StaffRepository extends Mapper<Staff> {

    @Select("select * from staff where userID = #{userID} limit 1")
    Staff findById(@Param("userID") String userID);

    @Select("select * from staff where userID = #{userID} and userPassword = #{userPassword} limit 1")
    Staff findByIDAndPasswd(@Param("userID") String userID,@Param("userPassword") String userPassword);

    @Update("UPDATE staff SET userPassword = #{userPassword} WHERE userID = #{userID}")
    public void updatePassword(@Param("userID") String userID, @Param("userPassword") String userPassword) ;
}
