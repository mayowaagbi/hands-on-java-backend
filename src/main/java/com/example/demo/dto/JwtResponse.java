
// src/main/java/com/example/demo/dto/JwtResponse.java

package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String tokenType = "Bearer";
    private Long id;
    private String email;
    
    public JwtResponse(String token, Long id, String email) {
        this.token = token;
        this.id = id;
        this.email = email;
    }
}