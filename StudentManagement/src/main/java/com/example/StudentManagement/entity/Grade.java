/**
 * @Description This class represents a Grade entity in the application.
 * It has properties to store grade information such as studentID, moduleCode, and grade.
 * @author Jiaming LIU
 * @Date 07/05/2024
 */
package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// It is annotated with JPA specifications to map the class properties to the columns of a database table.
@Entity
@Table(name = "grade")
public class Grade {
    /**
     * Unique identifier for the student
     */
    @Id
    @Column(name = "StudentID")
    private String studentID;

    /**
     * Unique identifier for the module
     */
    @Id
    @Column(name = "ModuleCode")
    private String moduleCode;

    /**
     * Grade of the student for the module
     */
    @Column(name = "Grade")
    private String grade;

    /**
     * Get the module code
     * @return The module code
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Get the student ID
     * @return The student ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Get the grade
     * @return The grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Set the module code
     * @param moduleCode The new module code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Set the student ID
     * @param studentID The new student ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Set the grade
     * @param grade The new grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
