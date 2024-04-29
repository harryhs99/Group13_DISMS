package com.example.StudentManagement.DTO;

public class AbsenceRequest {
    private String reason;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String description;

    public AbsenceRequest() {
        // 默认无参构造函数
    }

    public AbsenceRequest(String reason, String startDate, String endDate, String startTime, String endTime, String description) {
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    // Getter和Setter方法
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
