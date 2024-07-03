package com.example.StudentManagement.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @Column(name = "AssessmentID", nullable = false)
    private String assessmentID;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Location")
    private String location;

    @Column(name = "StartTime")
    private LocalDateTime startTime;

    @Column(name = "EndTime")
    private LocalDateTime endTime;

    @Column(name = "ModuleCode", nullable = false)
    private String moduleCode;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "StudentID", nullable = false)
    private String studentID;

    // getter and setter methods
    public String getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(String assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}

