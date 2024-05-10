package com.example.StudentManagement.controller;

import com.example.StudentManagement.dao.StaffRepository;
import com.example.StudentManagement.dao.StudentRepository;
import com.example.StudentManagement.entity.Staff;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.service.EmailService;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description This class provides a controller for handling email-related requests.
 * It has methods to send an email, send an absence request, send a suspension request, and send a meeting request.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@RestController
@CrossOrigin
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StaffRepository staffRepository;

    /**
     * Send an email.
     * This is a test for sending email.
     * Possible request parameter to add: @RequestParam String to, @RequestParam String subject, @RequestParam String body
     * @return A string indicating the email was sent successfully.
     */
    @PostMapping("/sendEmail")
    public String sendEmail() {
        String to = "liuyc2333@gmail.com";
        String subject = "testSubject";
        String body = "This is a test email";
        emailService.sendEmail(to, subject, body);
        return "Email sent successfully";
    }

    /**
     * Send an absence request email to the tutor of a student.
     * Now the email body is only using a simple template.
     * Could get the form filled out by the student on the website to generate the email body.
     * @param student The student who is sending the absence request.
     * @return A ResponseEntity indicating the status of the request.
     */
    @PostMapping("/sendAbsenceReq")
    public ResponseEntity<String>  sendAbsenceReq(@RequestBody Student student) {
        student = studentRepository.findById(student.getUserID());
        Staff tutor = staffRepository.findById(student.getTutor());
        String to = tutor.getEmail();
        String subject = "Absence Request";
        String body = "Please do not reply. This is an automatically generated email.\n" +
                "Your assigned student "+student.getfName()+" "+student.getlName()+" sent you an absence request";
        emailService.sendEmail(to, subject, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Send a suspension request email to the tutor of a student.
     * Now the email body is only using a simple template.
     * Could get the form filled out by the student on the website to generate the email body.
     * @param student The student who is sending the suspension request.
     * @return A ResponseEntity indicating the status of the request.
     */
    @PostMapping("/sendSuspendReq")
    public ResponseEntity<String>  sendSuspendReq(@RequestBody Student student) {
        student = studentRepository.findById(student.getUserID());
        Staff tutor = staffRepository.findById(student.getTutor());
        String to = tutor.getEmail();
        String subject = "Suspend Request";
        String body = "Please do not reply. This is an automatically generated email. " +
                "Your assigned student "+student.getfName()+" "+student.getlName()+" sent you a suspend request";
        emailService.sendEmail(to, subject, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Send a meeting request email to the tutor of a student.
     * Now the email body is only using a simple template.
     * Could get the form filled out by the student on the website to generate the email body.
     * @param student The student who is sending the meeting request.
     * @return A ResponseEntity indicating the status of the request.
     */
    @PostMapping("/sendMeetingReq")
    public ResponseEntity<String>  sendMeetingReq(@RequestBody Student student) {
        student = studentRepository.findById(student.getUserID());
        Staff tutor = staffRepository.findById(student.getTutor());
        String to = tutor.getEmail();
        String subject = "Meeting Request";
        String body = "Please do not reply. This is an automatically generated email.\n " +
                "Your assigned student "+student.getfName()+" "+student.getlName()+" sent you a meeting request";
        emailService.sendEmail(to, subject, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
