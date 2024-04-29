package com.example.StudentManagement.Entity;

import java.util.Date;

public class Feedback {
    private String content;
    private int score;
    private Date timestamp;

    public Feedback(String content, int score) {
        this.content = content;
        this.score = score;
        this.timestamp = new Date(); // 当前时间作为反馈时间
    }

    // Getter 和 Setter 方法
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

