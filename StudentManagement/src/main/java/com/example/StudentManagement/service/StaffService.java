
package com.example.StudentManagement.service;

import com.example.StudentManagement.dao.CourseworkRepository;
import com.example.StudentManagement.dao.ExamRepository;
import com.example.StudentManagement.dao.StaffRepository;
import com.example.StudentManagement.dao.StudentRepository;
import com.example.StudentManagement.entity.Coursework;
import com.example.StudentManagement.entity.Staff;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Description This class provides services related to staff operations such as login, account activation,
 * password reset, and marking coursework.
 * @author Shuyi Yang
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@Service
public class StaffService {
    @Resource
    private StudentRepository stuDao;
    @Resource
    private ExamRepository examDao;
    @Resource
    private CourseworkRepository courseworkRepository;
    @Resource
    private StaffRepository staffDao;

    /**
     * Authenticates a staff member by checking the provided credentials against the database.
     *
     * @param staff The staff object containing the userID and password.
     * @return A string indicating the result of the authentication process.
     */
    public String login(Staff staff) {
        Staff databaseStaff = staffDao.findById(staff.getUserID());
        if (databaseStaff == null){
            return "this account doesn't exist or not Staff account";
        }
        if (databaseStaff.getUserPassword() == null || databaseStaff.getUserPassword().isEmpty()){
            return "this account need be actived";
        }
        if (!Objects.equals(staff.getUserPassword(), databaseStaff.getUserPassword())){
            return "passwd error";
        }
        return "successfully";
    }

    /**
     * Activates a staff account by setting an initial password.
     *
     * @param staff The staff object containing the userID.
     * @return A string indicating the result of the activation process.
     */
    public String active(Staff staff) {
        //find staff
        Staff databaseStaff = staffDao.findById(staff.getUserID());
        // check staff if exist
        if (databaseStaff != null ){
            // check if account been actived
            if("".equals(databaseStaff.getUserPassword()) || databaseStaff.getUserPassword() == null){
                staffDao.updatePassword(databaseStaff.getUserID(),databaseStaff.initialPasswd());
                return "successfully";
            }
            return "this account has already been actived";
        }
        return "doesn't exist this account";
    }

    /**
     * Resets the password for a staff account.
     *
     * @param staff The staff object containing the userID and the new password.
     * @return A string indicating the result of the password reset process.
     */
    public String forgetPwd(Staff staff) {
        if (staff.getUserPassword().length() > 8) {
            return "Passwd over 8 length";
        }
        Staff databaseStaff = staffDao.findById(staff.getUserID());
        if (databaseStaff == null ){
            return "Don't have this account";
        }
        if (databaseStaff.getUserPassword() == null || "".equals(databaseStaff.getUserPassword())){
            return "Your account need to be actived";
        }
        if (databaseStaff.getUserPassword().equals(staff.getUserPassword())){
            return "Your new password cannot be the same as your current password";
        }
        staffDao.updatePassword(staff.getUserID(), staff.getUserPassword());
        return "successfully";
    }

    /**
     * Marks a coursework assignment by updating its details in the database.
     *
     * @param coursework The coursework object containing the updated details.
     * @return A ResponseEntity containing the result of the operation.
     */
    public ResponseEntity<String> markCoursework(Coursework coursework){
        int updateResult = courseworkRepository.updateByPrimaryKeySelective(coursework);
        if(updateResult==0){return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coursework Not Found");}
        else {
            return ResponseEntity.ok("mark coursework successfully");
            //return new ResponseEntity<String>("mark coursework successfully",HttpStatus.OK);
        }
    }
}
