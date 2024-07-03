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

    @PostMapping("/sendEmail")
    public String sendEmail() {
        //@RequestParam String to, @RequestParam String subject, @RequestParam String body
        String to = "liuyc2333@gmail.com";
        String subject = "testSubject";
        String body = "This is a test email";
        emailService.sendEmail(to, subject, body);
        //System.out.println("test");
        return "Email sent successfully";
    }

    @PostMapping("/sendAbsenceReq")
    public ResponseEntity<String>  sendAbsenceReq(@RequestBody Student student) {
        //@RequestParam String to, @RequestParam String subject, @RequestParam String body
        student = studentRepository.findById(student.getUserID());
        Staff tutor = staffRepository.findById(student.getTutor());
        String to = tutor.getEmail();
        String subject = "Absence Request";
        String body = "Please do not reply. This is an automatically generated email.\n" +
                "Your assigned student "+student.getfName()+" "+student.getlName()+" sent you an absence request";
        emailService.sendEmail(to, subject, body);
        //System.out.println("test");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sendSuspendReq")
    public ResponseEntity<String>  sendSuspendReq(@RequestBody Student student) {
        //@RequestParam String to, @RequestParam String subject, @RequestParam String body
        student = studentRepository.findById(student.getUserID());
        Staff tutor = staffRepository.findById(student.getTutor());
        String to = tutor.getEmail();
        String subject = "Suspend Request";
        String body = "Please do not reply. This is an automatically generated email. " +
                "Your assigned student "+student.getfName()+" "+student.getlName()+" sent you a suspend request";
        emailService.sendEmail(to, subject, body);
        //System.out.println("test");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/sendMeetingReq")
    public ResponseEntity<String>  sendMeetingReq(@RequestBody Student student) {
        //@RequestParam String to, @RequestParam String subject, @RequestParam String body
        student = studentRepository.findById(student.getUserID());
        Staff tutor = staffRepository.findById(student.getTutor());
        String to = tutor.getEmail();
        String subject = "Meeting Request";
        String body = "Please do not reply. This is an automatically generated email.\n " +
                "Your assigned student "+student.getfName()+" "+student.getlName()+" sent you a meeting request";
        emailService.sendEmail(to, subject, body);
        //System.out.println("test");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

