
package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * @Description This interface defines a repository for Student entities.
 * It extends the Mapper interface from MyBatis to provide basic CRUD operations.
 * Additional custom methods are defined using MyBatis annotations.
 * @Author Shuyi Yang
 * @Date 07/05/2024
 */
@Repository
public interface StudentRepository extends Mapper<Student> {

    /**
     * Retrieves a Student entity from the database based on the student ID.
     *
     * @param userID The userID of the student.
     * @return The Student entity matching the userID, or null if not found.
     */
    @Select("select * from student where userID = #{UserID} limit 1")
    Student findByStudentId(@Param("UserID") String userID);

    /**
     * Retrieves a list of Student entities from the database based on the tutor ID.
     *
     * @param tutorID The userID of the tutor.
     * @return A list of Student entities assigned to the specified tutor.
     */
    @Select("select * from student where tutor = #{tutor}")
    List<Student> findByTutor(@Param("tutor") String tutorID);

    /**
     * Retrieves the email address of a student from the database based on the student ID.
     *
     * @param userID The userID of the student.
     * @return The email address of the student.
     */
    @Select("select StudentEmail from student where StudentID = #{UserID}")
    String findEmailByStudentID(@Param("StudentID") String userID);

    /**
     * Retrieves a Student entity from the database based on the userID.
     *
     * @param userID The userID of the student.
     * @return The Student entity matching the userID, or null if not found.
     */
    @Select("select * from student where UserID = #{userID} limit 1")
    Student findById(@Param("userID") String userID);

    /**
     * Retrieves a Student entity from the database based on the userID and password.
     *
     * @param userID       The userID of the student.
     * @param userPassword The password of the student.
     * @return The Student entity matching the userID and password, or null if not found.
     */
    @Select("select * from student where userID = #{userID} and userPassword = #{userPassword} limit 1")
    Student findByIDAndPasswd(@Param("userID") String userID, @Param("passwd") String userPassword);

    /**
     * Updates the password of a student in the database.
     *
     * @param userId       The userID of the student.
     * @param userPassword The new password to be set.
     */
    @Update("UPDATE student SET userPassword = #{userPassword} WHERE userID = #{userId}")
    public void updatePassword(@Param("userId") String userId, @Param("userPassword") String userPassword);
}