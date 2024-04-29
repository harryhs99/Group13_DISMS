package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Entity.Coursework;
import java.util.List;

public interface CourseworkRepository {
    Coursework addCoursework(Coursework coursework);
    Coursework updateCoursework(int id, Coursework updatedCoursework);
    Coursework deleteCoursework(int id);
    Coursework getCourseworkById(int id);
    List<Coursework> getAllCoursework();
}
