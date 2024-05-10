/**
 * @Description This class represents an Announcement entity in the application.
 * It has properties to store announcement information such as moduleCode, submitTime, and content.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
package com.example.StudentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

// It is annotated with JPA specifications to map the class properties to the columns of a database table.
@Entity
@Table(name = "announcement")
public class Announcement {
    /**
     * Unique identifier for the module
     */
    @Id
    @Column(name = "ModuleCode")
    private String moduleCode;

    /**
     * Submission time of the announcement
     */
    @Id
    @Column(name = "SubmitTime")
    private LocalDateTime submitTime;

    /**
     * Content of the announcement
     */
    @Column(name = "Content")
    private String content;

    // Getter methods

    /**
     * Get the module code
     * @return The module code
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Get the submission time of the announcement
     * @return The submission time of the announcement
     */
    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    /**
     * Get the content of the announcement
     * @return The content of the announcement
     */
    public String getContent() {
        return content;
    }

    // Setter methods

    /**
     * Set the module code
     * @param moduleCode The new module code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Set the content of the announcement
     * @param content The new content of the announcement
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Set the submission time of the announcement
     * @param submitTime The new submission time of the announcement
     */
    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }
}
