package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @Column(name = "StudentID")
    private String studentID;
    @Id
    @Column(name = "ModuleCode")
    private String moduleCode;
    @Column(name = "Grade")
    private String grade;

    public String getModuleCode() {
        return moduleCode;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getGrade() {
        return grade;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
