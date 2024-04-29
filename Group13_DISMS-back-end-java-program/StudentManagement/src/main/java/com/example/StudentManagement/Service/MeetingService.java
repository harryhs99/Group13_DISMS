package com.example.StudentManagement.Service;

import com.example.StudentManagement.DTO.MeetingRequest;
import com.example.StudentManagement.Entity.Meeting;
import com.example.StudentManagement.Repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @Transactional
    public Meeting bookMeeting(MeetingRequest meetingRequest) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate bookingDate = LocalDate.parse(meetingRequest.getBookingDate(), dateFormatter);
        LocalTime bookingTime = LocalTime.parse(meetingRequest.getBookingTime(), timeFormatter);

        Meeting meeting = new Meeting();
        meeting.setTutorName(meetingRequest.getTutorName());
        meeting.setTutorId(meetingRequest.getTutorId());
        meeting.setTutorEmail(meetingRequest.getTutorEmail());
        meeting.setTopic(meetingRequest.getTopic());
        meeting.setLocation(meetingRequest.getLocation());
        meeting.setStartTime(bookingDate.atTime(bookingTime));
        meeting.setEndTime(bookingDate.atTime(bookingTime).plusHours(1)); // 假设会议时间为1小时

        return meetingRepository.save(meeting);
    }

    // 其他与会议相关的服务方法
}
