package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    @Column(name = "ModuleCode")
    private String moduleCode;
    @Id
    @Column(name = "SubmitTime")
    private LocalDateTime submitTime;
    @Column(name = "Content")
    private String content;

    public String getModuleCode() {
        return moduleCode;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public String getContent() {
        return content;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

}
