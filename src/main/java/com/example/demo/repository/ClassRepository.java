
// src/main/java/com/example/demo/repository/ClassRepository.java

package com.example.demo.repository;

import com.example.demo.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    List<ClassEntity> findByClassTeacher_TeacherId(Long teacherId);
}