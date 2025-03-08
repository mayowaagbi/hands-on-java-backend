package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String section;

    @ManyToOne
    @JoinColumn(name = "class_teacher_id", nullable = false)
    private Teacher classTeacher;
}