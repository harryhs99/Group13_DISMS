package com.example.StudentManagement.Entity;
import java.util.Date;

public class Coursework {
    private String title;
    private String description;
    private Date deadline;
    private String submissionRequirements;
    private Feedback feedback; // 添加了名为 'feedback' 的字段

    // 构造函数
    public Coursework(String title, String description, Date deadline, String submissionRequirements) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.submissionRequirements = submissionRequirements;
    }

    // Getter 和 Setter 方法

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getSubmissionRequirements() {
        return submissionRequirements;
    }

    public void setSubmissionRequirements(String submissionRequirements) {
        this.submissionRequirements = submissionRequirements;
    }

    // 添加 setFeedback 方法
    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    // 添加 getFeedback 方法
    public Feedback getFeedback() {
        return feedback;
    }
}
