
package com.example.StudentManagement.dao;

import com.example.StudentManagement.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * @Description This interface defines a repository for Staff entities.
 * It extends the Mapper interface from MyBatis to provide basic CRUD operations.
 * Additional custom methods are defined using MyBatis annotations.
 * @Author Shuyi Yang
 * @Date 07/05/2024
 */
@Repository
public interface StaffRepository extends Mapper<Staff> {

    /**
     * Retrieves a Staff entity from the database based on the userID.
     *
     * @param userID The userID of the staff member.
     * @return The Staff entity matching the userID, or null if not found.
     */
    @Select("select * from staff where userID = #{userID} limit 1")
    Staff findById(@Param("userID") String userID);

    /**
     * Retrieves a Staff entity from the database based on the userID and password.
     *
     * @param userID       The userID of the staff member.
     * @param userPassword The password of the staff member.
     * @return The Staff entity matching the userID and password, or null if not found.
     */
    @Select("select * from staff where userID = #{userID} and userPassword = #{userPassword} limit 1")
    Staff findByIDAndPasswd(@Param("userID") String userID, @Param("userPassword") String userPassword);

    /**
     * Updates the password of a staff member in the database.
     *
     * @param userID       The userID of the staff member.
     * @param userPassword The new password to be set.
     */
    @Update("UPDATE staff SET userPassword = #{userPassword} WHERE userID = #{userID}")
    public void updatePassword(@Param("userID") String userID, @Param("userPassword") String userPassword);
}