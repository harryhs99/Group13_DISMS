package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "module")
public class Modules {
    @Id
    @Column(name = "ModuleCode", nullable = false)
    private String ModuleCode;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Timetable")
    private String timetable;
    public Modules(){}
    public String getModuleCode() {
        return ModuleCode;
    }

    public String getTitle() {
        return title;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setModuleCode(String moduleCode) {
        ModuleCode = moduleCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }
}
