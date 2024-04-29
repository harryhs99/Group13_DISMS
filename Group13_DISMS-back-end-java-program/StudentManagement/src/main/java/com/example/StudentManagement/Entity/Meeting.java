package com.example.StudentManagement.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tutorName;
    private String tutorId;
    private String tutorEmail;
    private String topic;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // 无参构造函数
    public Meeting() {
    }

    // 全参构造函数
    public Meeting(String tutorName, String tutorId, String tutorEmail, String topic, String location, LocalDateTime startTime, LocalDateTime endTime) {
        this.tutorName = tutorName;
        this.tutorId = tutorId;
        this.tutorEmail = tutorEmail;
        this.topic = topic;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorEmail() {
        return tutorEmail;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
}
