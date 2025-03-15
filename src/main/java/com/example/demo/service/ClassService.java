// src/main/java/com/example/classmanagement/service/ClassService.java

package com.example.demo.service;

import com.example.demo.dto.ClassDto;
import com.example.demo.model.ClassEntity;
import com.example.demo.model.Teacher;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {

    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;

    public ClassService(ClassRepository classRepository, TeacherRepository teacherRepository) {
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
    }

    public ClassDto createClass(ClassDto classDto) {
        Teacher teacher = teacherRepository.findById(classDto.getClassTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassName(classDto.getClassName());
        classEntity.setSection(classDto.getSection());
        classEntity.setClassTeacher(teacher);

        ClassEntity savedClass = classRepository.save(classEntity);
        return convertToDto(savedClass);
    }

    public ClassDto getClassById(Long id) {
        ClassEntity classEntity = classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        return convertToDto(classEntity);
    }

    public List<ClassDto> getAllClasses() {
        return classRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ClassDto updateClass(Long id, ClassDto classDto) {
        ClassEntity classEntity = classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Teacher teacher = teacherRepository.findById(classDto.getClassTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        classEntity.setClassName(classDto.getClassName());
        classEntity.setSection(classDto.getSection());
        classEntity.setClassTeacher(teacher);

        ClassEntity updatedClass = classRepository.save(classEntity);
        return convertToDto(updatedClass);
    }

    public void deleteClass(Long id) {
        ClassEntity classEntity = classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        classRepository.delete(classEntity);
    }

    private ClassDto convertToDto(ClassEntity classEntity) {
        ClassDto classDto = new ClassDto();
        classDto.setClassId(classEntity.getClassId());
        classDto.setClassName(classEntity.getClassName());
        classDto.setSection(classEntity.getSection());
        classDto.setClassTeacherId(classEntity.getClassTeacher().getTeacherId());
        return classDto;
    }
}
