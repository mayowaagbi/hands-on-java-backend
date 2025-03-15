// src/main/java/com/example/demo/dto/LoginRequest.java

package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
}