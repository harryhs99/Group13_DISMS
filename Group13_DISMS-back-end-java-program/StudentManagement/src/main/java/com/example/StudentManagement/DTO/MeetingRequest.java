package com.example.StudentManagement.DTO;

public class MeetingRequest {
    private String tutorName;  // 导师的名字
    private String tutorId;    // 导师的ID
    private String tutorEmail; // 导师的电子邮件
    private String bookingDate;// 预定的日期
    private String bookingTime; // 此处添加了 bookingTime 属性
    private String topic;      // 会议主题
    private String location;   // 会议地点
    private String startTime;  // 开始时间
    private String endTime;    // 结束时间

    public MeetingRequest() {
        // 无参构造函数
    }

    // 添加构造函数
    public MeetingRequest(String tutorName, String tutorId, String tutorEmail, String bookingDate, String bookingTime, String topic, String location, String startTime, String endTime) {
        this.tutorName = tutorName;
        this.tutorId = tutorId;
        this.tutorEmail = tutorEmail;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.topic = topic;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 添加 getter 和 setter 方法

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

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public String getBookingTime() {
        return bookingTime;
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
}
