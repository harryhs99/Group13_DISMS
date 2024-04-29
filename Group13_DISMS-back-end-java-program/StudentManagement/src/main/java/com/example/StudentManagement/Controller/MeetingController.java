package com.example.StudentManagement.Controller;

import com.example.StudentManagement.DTO.MeetingRequest;
import com.example.StudentManagement.Entity.Meeting;
import com.example.StudentManagement.Service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping("/book")
    public ResponseEntity<Meeting> bookMeeting(@RequestBody MeetingRequest meetingRequest) {
        Meeting bookedMeeting = meetingService.bookMeeting(meetingRequest);
        return ResponseEntity.ok(bookedMeeting);
    }

    // 你可以添加更多与会议相关的处理方法，如取消预订、查询会议等
}

