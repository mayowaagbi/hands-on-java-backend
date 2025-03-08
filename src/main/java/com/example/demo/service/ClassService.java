package com.example.demo.service;

import com.example.demo.entity.Class;
import com.example.demo.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;

    public Class createClass(Class newClass) {
        return classRepository.save(newClass);
    }

    public Class getClassById(Long id) {
        return classRepository.findById(id).orElseThrow();
    }

    public Class updateClass(Long id, Class updatedClass) {
        Class existingClass = getClassById(id);
        existingClass.setClassName(updatedClass.getClassName());
        existingClass.setSection(updatedClass.getSection());
        existingClass.setClassTeacher(updatedClass.getClassTeacher());
        return classRepository.save(existingClass);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }
}