// src/main/java/com/example/classmanagement/dto/ClassDto.java

package com.example.demo.dto;

import lombok.Data;

@Data
public class ClassDto {
    private Long classId;
    private String className;
    private String section;
    private Long classTeacherId;
}