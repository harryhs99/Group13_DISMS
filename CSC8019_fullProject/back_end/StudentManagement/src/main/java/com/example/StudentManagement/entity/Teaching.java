package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teaching")
public class Teaching {
    @Id
    @Column(name = "ModuleCode")
    private String moduleCode;
    @Id
    @Column(name = "StaffID")
    private String staffID;

    public String getModuleCode() {
        return moduleCode;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
}
