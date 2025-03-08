package com.example.demo.controller;

import com.example.demo.entity.Class;
import com.example.demo.service.ClassService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @PostMapping
    public ResponseEntity<Class> createClass(@RequestBody Class newClass) {
        return ResponseEntity.ok(classService.createClass(newClass));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class updatedClass) {
        return ResponseEntity.ok(classService.updateClass(id, updatedClass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Class>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }
}