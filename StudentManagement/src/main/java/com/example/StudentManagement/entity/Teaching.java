/**
 * @Description This class represents a Teaching entity in the application.
 * It has properties to store teaching information such as moduleCode and staffID.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// It is annotated with JPA specifications to map the class properties to the columns of a database table.
@Entity
@Table(name = "teaching")
public class Teaching {
    /**
     * Unique identifier for the module
     */
    @Id
    @Column(name = "ModuleCode")
    private String moduleCode;

    /**
     * Unique identifier for the staff
     */
    @Id
    @Column(name = "StaffID")
    private String staffID;

    /**
     * Get the module code
     * @return The module code
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Get the staff ID
     * @return The staff ID
     */
    public String getStaffID() {
        return staffID;
    }

    /**
     * Set the module code
     * @param moduleCode The new module code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Set the staff ID
     * @param staffID The new staff ID
     */
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
}
