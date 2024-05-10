/**
 * @Description This class represents an Exam entity in the application.
 * It has properties to store exam information such as assessmentID, title, location, startTime, endTime, moduleCode, grade, and studentID.
 * @author Jiaming LIU
 * @Date 07/05/2024
 */
package com.example.StudentManagement.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

// It is annotated with JPA specifications to map the class properties to the columns of a database table.
@Entity
@Table(name = "exam")
public class Exam {

    /**
     * Unique identifier for the exam
     */
    @Id
    @Column(name = "AssessmentID", nullable = false)
    private String assessmentID;

    /**
     * Title of the exam
     */
    @Column(name = "Title", nullable = false)
    private String title;

    /**
     * Location where the exam is held
     * not used in current implementation
     * could be used in future extension
     */
    @Column(name = "Location")
    private String location;

    /**
     * Start time of the exam
     */
    @Column(name = "StartTime")
    private LocalDateTime startTime;

    /**
     * End time of the exam
     */
    @Column(name = "EndTime")
    private LocalDateTime endTime;

    /**
     * Code of the module to which the exam belongs
     */
    @Column(name = "ModuleCode", nullable = false)
    private String moduleCode;

    /**
     * Grade received by the student for this exam
     */
    @Column(name = "grade")
    private Integer grade;

    /**
     * ID of the student who took the exam
     */
    @Column(name = "StudentID", nullable = false)
    private String studentID;

    // Getter and setter methods

    /**
     * Get the assessment ID
     * @return The assessment ID
     */
    public String getAssessmentID() {
        return assessmentID;
    }

    /**
     * Set the assessment ID
     * @param assessmentID The new assessment ID
     */
    public void setAssessmentID(String assessmentID) {
        this.assessmentID = assessmentID;
    }

    /**
     * Get the title of the exam
     * @return The title of the exam
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the exam
     * @param title The new title of the exam
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the location of the exam
     * @return The location of the exam
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location of the exam
     * @param location The new location of the exam
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the start time of the exam
     * @return The start time of the exam
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * Set the start time of the exam
     * @param startTime The new start time of the exam
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Get the end time of the exam
     * @return The end time of the exam
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * Set the end time of the exam
     * @param endTime The new end time of the exam
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Get the module code
     * @return The module code
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Set the module code
     * @param moduleCode The new module code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Get the grade
     * @return The grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * Set the grade
     * @param grade The new grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * Get the student ID
     * @return The student ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Set the student ID
     * @param studentID The new student ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
