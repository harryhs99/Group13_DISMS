/**
 * @Description This class represents a Modules entity in the application.
 * It has properties to store module information such as ModuleCode, title, and timetable.
 * @author Jiaming LIU
 * @Date 07/05/2024
 */
package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// It is annotated with JPA specifications to map the class properties to the columns of a database table.
@Entity
@Table(name = "module")
public class Modules {

    /**
     * Unique code identifier for the module
     */
    @Id
    @Column(name = "ModuleCode", nullable = false)
    private String ModuleCode;

    /**
     * Name or title of the module
     */
    @Column(name = "Title", nullable = false)
    private String title;

    /**
     * Schedule timings for the module sessions
     */
    @Column(name = "Timetable")
    private String timetable;

    /**
     * Default constructor.
     */
    public Modules() {}

    // Getter methods

    /**
     * Returns the module code.
     * @return Module code as a string.
     */
    public String getModuleCode() {
        return ModuleCode;
    }

    /**
     * Returns the title of the module.
     * @return Title as a string.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the timetable for the module.
     * @return Timetable as a string.
     */
    public String getTimetable() {
        return timetable;
    }

    // Setter methods

    /**
     * Sets the module code.
     * @param moduleCode A string representing the new module code.
     */
    public void setModuleCode(String moduleCode) {
        ModuleCode = moduleCode;
    }

    /**
     * Sets the title of the module.
     * @param title A string representing the new title of the module.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the timetable for the module.
     * @param timetable A string representing the new timetable.
     */
    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }
}
