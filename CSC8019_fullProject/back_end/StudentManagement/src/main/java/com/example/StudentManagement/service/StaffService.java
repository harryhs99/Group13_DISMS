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

    public ResponseEntity<String> markCoursework(Coursework coursework){
        int updateResult = courseworkRepository.updateByPrimaryKeySelective(coursework);
        if(updateResult==0){return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coursework Not Found");}
        else {
            return ResponseEntity.ok("mark coursework successfully");
            //return new ResponseEntity<String>("mark coursework successfully",HttpStatus.OK);
        }
    }
}
