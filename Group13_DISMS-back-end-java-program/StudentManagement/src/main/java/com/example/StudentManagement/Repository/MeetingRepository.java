package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    // 根据导师的ID来查找会议
    List<Meeting> findByTutorId(String tutorId);


}

