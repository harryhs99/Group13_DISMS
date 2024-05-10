/**
 * @Description This class represents a Student entity in the application.
 * It has properties to store student information such as userID, password,
 * name, email, address, telephone, joined date, tutor, timetable, academic history, and programme code.
 * @author Shuyi Yang
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
package com.example.StudentManagement.entity;

import lombok.Getter;
import javax.persistence.*;

//It is annotated with JPA specifications to automatically generate all getter methods.
@Getter
//It is annotated with JPA specifications to map the class properties to the columns of a database table.
@Table(name = "student")
public class Student {

    /**
     * Default password for new students
     */
    private final static String ORIGIN_PASSWD = "123456";

    /**
     * Unique identifier for the student
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // JPA annotations for mapping the entity properties to the database columns
    @Column(name = "userID")
    private String userID;

    /**
     * Password for the student
     */
    @Column(name = "userPassword")
    private String userPassword;

    /**
     * First name of the student
     */
    @Column(name = "fName")
    private String fName;

    /**
     * Last name of the student
     */
    @Column(name = "lName")
    private String lName;

    /**
     * Email address of the student
     */
    @Column(name = "email")
    private String email;

    /**
     * Residential address of the student
     */
    @Column(name = "address")
    private String address;

    /**
     * Telephone number of the student
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * Date the student joined the institution
     */
    @Column(name = "joinedDate")
    private String joinedDate;

    /**
     * Tutor assigned to the student
     */
    @Column(name = "tutor")
    private String tutor;

    /**
     * Timetable or schedule of the student
     */
    @Column(name = "timetable")
    private String timetable;

    /**
     * Academic history of the student
     */
    @Column(name = "academicHistory")
    private String academicHistory;

    /**
     * Programme code of the student's course
     */
    @Column(name = "programmeCode")
    private String programmeCode;

    // Getter methods for all properties

    /**
     * Set the userID of the student
     * @param userID The new userID of the student
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Set the password of the student
     * @param userPassword The new password of the student
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Set the first name of the student
     * @param fName The new first name of the student
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /**
     * Set the last name of the student
     * @param lName The new last name of the student
     */
    public void setLName(String lName) {
        this.lName = lName;
    }

    /**
     * Set the email of the student
     * @param email The new email of the student
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the address of the student
     * @param address The new address of the student
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the telephone number of the student
     * @param telephone The new telephone number of the student
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Set the joined date of the student
     * @param joinedDate The new joined date of the student
     */
    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    /**
     * Set the tutor of the student
     * @param tutor The new tutor of the student
     */
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    /**
     * Set the timetable of the student
     * @param timetable The new timetable of the student
     */
    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    /**
     * Set the academic history of the student
     * @param academicHistory The new academic history of the student
     */
    public void setAcademicHistory(String academicHistory) {
        this.academicHistory = academicHistory;
    }

    /**
     * Set the programme code of the student
     * @param programmeCode The new programme code of the student
     */
    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    /**
     * Return a string representation of the student
     * @return A string containing the userID and password of the student
     */
    @Override
    public String toString() {
        return "userID: " + getUserID() + "\n" + "pwd: " + getUserPassword() + "\n";
    }

    /**
     * Check if two students are equal based on userID
     * @param obj The object to compare with this student
     * @return true if the objects are equal, false otherwise
     */
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

    /**
     * Set the initial password for a new student
     * @return The initial password
     */
    public String initialPasswd() {
        this.setUserPassword(ORIGIN_PASSWD);
        return getUserPassword();
    }
}