package com.example.StudentManagement.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Grade {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ExamRegistration examRegistration;

    private double score;

    // 构造函数
    public Grade() {
        // 无参构造函数
    }

    public Grade(ExamRegistration examRegistration, double score) {
        this.examRegistration = examRegistration;
        this.score = score;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExamRegistration getExamRegistration() {
        return examRegistration;
    }

    public void setExamRegistration(ExamRegistration examRegistration) {
        this.examRegistration = examRegistration;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
