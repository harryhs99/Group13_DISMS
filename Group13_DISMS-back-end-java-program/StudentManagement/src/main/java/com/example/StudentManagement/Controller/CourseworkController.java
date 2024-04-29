package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Entity.Coursework;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/coursework")
public class CourseworkController {
    private List<Coursework> courseworkList = new ArrayList<>();

    // 创建作业
    @PostMapping("/create")
    public Coursework createCoursework(@RequestBody Coursework coursework) {
        courseworkList.add(coursework);
        return coursework;
    }

    // 编辑作业
    @PutMapping("/edit/{id}")
    public Coursework editCoursework(@PathVariable int id, @RequestBody Coursework updatedCoursework) {
        if (id >= 0 && id < courseworkList.size()) {
            courseworkList.set(id, updatedCoursework);
            return updatedCoursework;
        } else {
            return null;
        }
    }

    // 删除作业
    @DeleteMapping("/delete/{id}")
    public Coursework deleteCoursework(@PathVariable int id) {
        if (id >= 0 && id < courseworkList.size()) {
            return courseworkList.remove(id);
        } else {
            return null;
        }
    }

    // 查询所有作业
    @GetMapping("/all")
    public List<Coursework> getAllCoursework() {
        return courseworkList;
    }
}
