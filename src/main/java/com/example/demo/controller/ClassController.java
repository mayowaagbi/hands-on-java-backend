// src/main/java/com/example/classmanagement/controller/ClassController.java

package com.example.demo.controller;

import com.example.demo.dto.ClassDto;
import com.example.demo.service.ClassService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<ClassDto> createClass(@Valid @RequestBody ClassDto classDto) {
        return ResponseEntity.ok(classService.createClass(classDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable Long id) {
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClassDto>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassDto> updateClass(@PathVariable Long id, @Valid @RequestBody ClassDto classDto) {
        return ResponseEntity.ok(classService.updateClass(id, classDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.ok().build();
    }
}