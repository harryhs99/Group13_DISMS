package com.example.StudentManagement.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "staff")
public class Staff {
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
    @Column(name = "position")
    private String position;
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "timetable")
    private String timetable;

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

    public String getPosition() {
        return position;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "userID: "+this.getUserID()+"\n"+"pwd: "+getUserPassword()+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Staff staff = (Staff) obj;
        return getUserID().equals(staff.getUserID());
    }

    public String initialPasswd() {
        this.setUserPassword(ORIGIN_PASSWD);
        return getUserPassword();
    }
}
