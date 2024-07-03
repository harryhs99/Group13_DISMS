package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StudentRepository extends Mapper<Student> {

    @Select("select * from student where userID = #{UserID} limit 1")
    Student findByStudentId(@Param("UserID") String userID);

    @Select("select * from student where tutor = #{tutor}")
    List<Student> findByTutor(@Param("tutor") String tutorID);

    @Select("select StudentEmail from student where StudentID = #{UserID}")
    String findEmailByStudentID(@Param("StudentID") String userID);

    @Select("select * from student where UserID = #{userID} limit 1")
    Student findById(@Param("userID") String userID);

    @Select("select * from student where userID = #{userID} and userPassword = #{userPassword} limit 1")
    Student findByIDAndPasswd(@Param("userID") String userID,@Param("passwd") String userPassword);

    @Update("UPDATE student SET userPassword = #{userPassword} WHERE userID = #{userId}")
    public void updatePassword(@Param("userId") String userId, @Param("userPassword") String userPassword) ;
}
