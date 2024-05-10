/**
 * @Description This class represents a Staff entity in the application.
 * It has properties to store staff information such as userID, password,
 * name, email, address, telephone, joined date, position, faculty, and timetable
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
@Table(name = "staff")
public class Staff {

    /**
     * Default password for new staff members
     */
    private final static String ORIGIN_PASSWD = "123456";

    /**
     * Unique identifier for the staff member
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // JPA annotations for mapping the entity properties to the database columns
    @Column(name = "userID")
    private String userID;

    /**
     * Password for the staff member
     */
    @Column(name = "userPassword")
    private String userPassword;

    /**
     * First name of the staff member
     */
    @Column(name = "fName")
    private String fName;

    /**
     * Last name of the staff member
     */
    @Column(name = "lName")
    private String lName;

    /**
     * Email address of the staff member
     */
    @Column(name = "email")
    private String email;

    /**
     * Residential address of the staff member
     */
    @Column(name = "address")
    private String address;

    /**
     * Telephone number of the staff member
     */
    @Column(name = "telephone")
    private String telephone;

    /**
     * Date the staff member joined the organization
     */
    @Column(name = "joinedDate")
    private String joinedDate;

    /**
     * Job position or role of the staff member
     */
    @Column(name = "position")
    private String position;

    /**
     * Faculty or department the staff member belongs to
     */
    @Column(name = "faculty")
    private String faculty;

    /**
     * Timetable or schedule of the staff member
     */
    @Column(name = "timetable")
    private String timetable;

    // Getter methods for all properties

    /**
     * Set the address of the staff member
     * @param address The new address of the staff member
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the email of the staff member
     * @param email The new email of the staff member
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the faculty of the staff member
     * @param faculty The new faculty of the staff member
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Set the first name of the staff member
     * @param fName The new first name of the staff member
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Set the joined date of the staff member
     * @param joinedDate The new joined date of the staff member
     */
    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    /**
     * Set the last name of the staff member
     * @param lName The new last name of the staff member
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Set the position of the staff member
     * @param position The new position of the staff member
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Set the telephone number of the staff member
     * @param telephone The new telephone number of the staff member
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Set the timetable of the staff member
     * @param timetable The new timetable of the staff member
     */
    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    /**
     * Set the userID of the staff member
     * @param userID The new userID of the staff member
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Set the password of the staff member
     * @param userPassword The new password of the staff member
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Return a string representation of the staff member
     * @return A string containing the userID and password of the staff member
     */
    @Override
    public String toString() {
        return "userID: " + this.getUserID() + "\\n" + "pwd: " + getUserPassword() + "\\n";
    }

    /**
     * Check if two staff members are equal based on userID
     * @param obj The object to compare with this staff member
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
        Staff staff = (Staff) obj;
        return getUserID().equals(staff.getUserID());
    }

    /**
     * Set the initial password for a new staff member
     * @return The initial password
     */
    public String initialPasswd() {
        this.setUserPassword(ORIGIN_PASSWD);
        return getUserPassword();
    }
}