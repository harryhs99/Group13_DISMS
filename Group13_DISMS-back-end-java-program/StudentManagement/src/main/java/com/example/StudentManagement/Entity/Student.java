package com.example.StudentManagement.Entity;

import java.time.LocalDateTime;

public class Student {
    private Long id;
    private String name;
    private String email;
    private boolean absentStatus; // 缺席状态
    private String absentReason; // 缺席原因
    private LocalDateTime meetingTime; // 预约会议时间
    private String meetingLocation; // 预约会议地点
    private String meetingTopic; // 预约会议主题
    private Tutor academicAdvisor; // 学术导师

    public Student() {
        // 无参构造函数
    }

    public Student(Long id, String name, String email, Tutor academicAdvisor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.academicAdvisor = academicAdvisor;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isAbsentStatus() {
        return absentStatus;
    }

    public void setAbsentStatus(boolean absentStatus) {
        this.absentStatus = absentStatus;
    }

    public String getAbsentReason() {
        return absentReason;
    }

    public void setAbsentReason(String absentReason) {
        this.absentReason = absentReason;
    }

    public LocalDateTime getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(LocalDateTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    public String getMeetingTopic() {
        return meetingTopic;
    }

    public void setMeetingTopic(String meetingTopic) {
        this.meetingTopic = meetingTopic;
    }

    public Tutor getAcademicAdvisor() {
        return academicAdvisor;
    }

    public void setAcademicAdvisor(Tutor academicAdvisor) {
        this.academicAdvisor = academicAdvisor;
    }
}
