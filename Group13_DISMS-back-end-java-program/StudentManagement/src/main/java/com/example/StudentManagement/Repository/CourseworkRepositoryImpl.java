package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Entity.Coursework;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseworkRepositoryImpl implements CourseworkRepository {
    private List<Coursework> courseworkList = new ArrayList<>();

    @Override
    public Coursework addCoursework(Coursework coursework) {
        courseworkList.add(coursework);
        return coursework;
    }

    @Override
    public Coursework updateCoursework(int id, Coursework updatedCoursework) {
        if (id >= 0 && id < courseworkList.size()) {
            courseworkList.set(id, updatedCoursework);
            return updatedCoursework;
        } else {
            return null;
        }
    }

    @Override
    public Coursework deleteCoursework(int id) {
        if (id >= 0 && id < courseworkList.size()) {
            return courseworkList.remove(id);
        } else {
            return null;
        }
    }

    @Override
    public Coursework getCourseworkById(int id) {
        if (id >= 0 && id < courseworkList.size()) {
            return courseworkList.get(id);
        } else {
            return null;
        }
    }

    @Override
    public List<Coursework> getAllCoursework() {
        return courseworkList;
    }
}
