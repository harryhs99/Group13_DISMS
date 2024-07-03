package com.example.StudentManagement.entity;

import javax.persistence.*;

import java.util.Date;
import java.sql.Timestamp;


@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private String userID;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "joinedDate")
    private Timestamp joinDate;

    public User(String userID,
                String passwd,
                String name,
                String email,
                String address,
                String telephone) {
        this.userID = userID;
        this.passwd = passwd;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        this.joinDate = time;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }
}

