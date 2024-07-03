package com.example.StudentManagement.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coursework")
public class Coursework {

    @Id
    @Column(name = "AssessmentID", nullable = false)
    private String assessmentID;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Deadline")
    private LocalDateTime deadline;

    @Column(name = "ModuleCode", nullable = false)
    private String moduleCode;

    @Column(name = "Grade")
    private Integer grade;

    @Column(name = "Feedback")
    private String feedback;

    @Column(name = "FilePath")
    private String filePath;

    @Column(name = "StudentID", nullable = false)
    private String studentID;

    // getters and setters

    public String getFeedback() {
        return feedback;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getTitle() {
        return title;
    }

    public Integer getGrade() {
        return grade;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getAssessmentID() {
        return assessmentID;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAssessmentID(String assessmentID) {
        this.assessmentID = assessmentID;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
