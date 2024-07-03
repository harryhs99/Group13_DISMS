//package com.example.StudentManagement.controller;
//import com.example.StudentManagement.dao.StudentRepository;
//import com.example.StudentManagement.entity.Student;
//import jakarta.annotation.Resource;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//
//@RestController
//@CrossOrigin
//public class LoginController {
//    @Resource
//    private StudentRepository stuDao;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user) {
//        // 打印接收到的用户名和密码
//        System.out.println("Received username: " + user.getUsername());
//        System.out.println("Received password: " + user.getPassword());
//
//        // 返回一个成功的消息
//        if(user.getUsername().equals("123")&&user.getPassword().equals("123")){
//            return new ResponseEntity<String>("mark coursework successfully",HttpStatus.OK);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
//    }
//    @CrossOrigin
//    @PostMapping("/active")
//    public ResponseEntity<String> activate(@RequestBody User user) {
//        // 打印接收到的用户名和密码
//        System.out.println("Received username: " + user.getUsername());
//        System.out.println("Received password: " + user.getEmail());
//
//        // 返回一个成功的消息
////        if(user.getUsername().equals("123")&&user.getPassword().equals("123")){
////            return new ResponseEntity<String>("mark coursework successfully",HttpStatus.OK);
////        }
//        return new ResponseEntity<String>("mark coursework successfully",HttpStatus.OK);
//    }
//
//    @GetMapping("/userinfo")
//    public Student getUserInfo() {
//        Student testStudent= stuDao.findById("testUser1");
//        System.out.println("Get Request received!");
////        User user = new User();
////        user.setFullName("TestUser");
////        user.setUserID("TestID123");
////        user.setEmail("Leo@example.com");
////        user.setMajor("Computer science");
////        user.setFeedback("This is some feedback");
//
//        return testStudent;
//    }
//    public static class User {
//        private String username;
//        private String password;
//        private String fullName;
//        private String userID;
//        private String email;
//        private String major;
//        private String feedback;
//
//        public User(){}
//        // getter和setter方法
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public String getFeedback() {
//            return feedback;
//        }
//
//        public String getFullName() {
//            return fullName;
//        }
//
//        public String getMajor() {
//            return major;
//        }
//
//        public String getUserID() {
//            return userID;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public void setFeedback(String feedback) {
//            this.feedback = feedback;
//        }
//
//        public void setFullName(String fullName) {
//            this.fullName = fullName;
//        }
//
//        public void setMajor(String major) {
//            this.major = major;
//        }
//
//        public void setUserID(String userID) {
//            this.userID = userID;
//        }
//    }
//}
