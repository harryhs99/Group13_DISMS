package com.example.StudentManagement.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "student")
public class Student {
    private final static String ORIGIN_PASSWD = "123456";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private String userID;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "fName")
    private String fName;
    @Column(name = "lName")
    private String lName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "joinedDate")
    private String joinedDate;
    @Column(name = "tutor")
    private String tutor;
    @Column(name = "timetable")
    private String timetable;
    @Column(name = "academicHistory")
    private String academicHistory;
    @Column(name = "programmeCode")
        private String programmeCode;

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public String getTutor() {
        return tutor;
    }

    public String getTimetable() {
        return timetable;
    }

    public String getAcademicHistory() {
        return academicHistory;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {this.address = address;}
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }
    public void setAcademicHistory(String academicHistory) {
        this.academicHistory = academicHistory;
    }
    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    @Override
    public String toString() {
        return "userID: "+getUserID()+"\n"+"pwd: "+getUserPassword()+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return getUserID().equals(student.getUserID());
    }

    public String initialPasswd() {
        this.setUserPassword(ORIGIN_PASSWD);
        return getUserPassword();
    }
}