/**
 * @Description This class represents a Coursework entity in the application.
 * It has properties to store coursework information such as assessmentID, title, deadline, moduleCode, grade, feedback, filePath, and studentID.
 * @author Jiaming LIU
 * @Date 07/05/2024
 */
package com.example.StudentManagement.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

// It is annotated with JPA specifications to map the class properties to the columns of a database table.
@Entity
@Table(name = "coursework")
public class Coursework {

    /**
     * Unique identifier for the coursework
     */
    @Id
    @Column(name = "AssessmentID", nullable = false)
    private String assessmentID;

    /**
     * Title of the coursework
     */
    @Column(name = "Title", nullable = false)
    private String title;

    /**
     * Deadline of the coursework
     */
    @Column(name = "Deadline")
    private LocalDateTime deadline;

    /**
     * Code of the module to which the coursework belongs
     */
    @Column(name = "ModuleCode", nullable = false)
    private String moduleCode;

    /**
     * Grade received by the student for this coursework
     */
    @Column(name = "Grade")
    private Integer grade;

    /**
     * Feedback for the coursework
     */
    @Column(name = "Feedback")
    private String feedback;

    /**
     * File path of the coursework
     */
    @Column(name = "FilePath")
    private String filePath;

    /**
     * ID of the student who submitted the coursework
     */
    @Column(name = "StudentID", nullable = false)
    private String studentID;

    // Getter methods

    /**
     * Get the feedback of the coursework
     * @return The feedback of the coursework
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Get the module code
     * @return The module code
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Get the title of the coursework
     * @return The title of the coursework
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the grade of the coursework
     * @return The grade of the coursework
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * Get the deadline of the coursework
     * @return The deadline of the coursework
     */
    public LocalDateTime getDeadline() {
        return deadline;
    }

    /**
     * Get the assessment ID of the coursework
     * @return The assessment ID of the coursework
     */
    public String getAssessmentID() {
        return assessmentID;
    }

    /**
     * Get the file path of the coursework
     * @return The file path of the coursework
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Get the student ID
     * @return The student ID
     */
    public String getStudentID() {
        return studentID;
    }

    // Setter methods

    /**
     * Set the feedback of the coursework
     * @param feedback The new feedback of the coursework
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Set the module code
     * @param moduleCode The new module code
     */
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Set the title of the coursework
     * @param title The new title of the coursework
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set the assessment ID of the coursework
     * @param assessmentID The new assessment ID of the coursework
     */
    public void setAssessmentID(String assessmentID) {
        this.assessmentID = assessmentID;
    }

    /**
     * Set the deadline of the coursework
     * @param deadline The new deadline of the coursework
     */
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    /**
     * Set the file path of the coursework
     * @param filePath The new file path of the coursework
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Set the grade of the coursework
     * @param grade The new grade of the coursework
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * Set the student ID
     * @param studentID The new student ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
