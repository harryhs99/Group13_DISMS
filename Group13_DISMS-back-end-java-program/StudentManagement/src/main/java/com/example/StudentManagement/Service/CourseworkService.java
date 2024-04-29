package com.example.StudentManagement.Service;

import com.example.StudentManagement.Entity.Coursework;
import com.example.StudentManagement.Entity.Feedback;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseworkService {
    private List<Coursework> courseworkList = new ArrayList<>();

    // 添加课程作业
    public Coursework addCoursework(Coursework coursework) {
        courseworkList.add(coursework);
        return coursework;
    }

    // 更新课程作业
    public Coursework updateCoursework(int id, Coursework updatedCoursework) {
        if (id >= 0 && id < courseworkList.size()) {
            courseworkList.set(id, updatedCoursework);
            return updatedCoursework;
        } else {
            return null;
        }
    }

    // 删除课程作业
    public Coursework deleteCoursework(int id) {
        if (id >= 0 && id < courseworkList.size()) {
            return courseworkList.remove(id);
        } else {
            return null;
        }
    }

    // 获取所有课程作业
    public List<Coursework> getAllCoursework() {
        return courseworkList;
    }

    // 添加反馈
    public Feedback addFeedback(int courseId, Feedback feedback) {
        if (courseId >= 0 && courseId < courseworkList.size()) {
            Coursework coursework = courseworkList.get(courseId);
            coursework.setFeedback(feedback);
            return feedback;
        } else {
            return null;
        }
    }

    // 获取指定课程的反馈
    public Feedback getFeedback(int courseId) {
        if (courseId >= 0 && courseId < courseworkList.size()) {
            Coursework coursework = courseworkList.get(courseId);
            return coursework.getFeedback();
        } else {
            return null;
        }
    }
}
