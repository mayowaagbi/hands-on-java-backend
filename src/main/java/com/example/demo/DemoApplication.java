// src/main/java/com/example/demo/demoApplication.java

package com.example.demo;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Add a sample teacher on startup for testing
    @Bean
    public CommandLineRunner setupData(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!teacherRepository.existsByEmail("admin@example.com")) {
                Teacher teacher = new Teacher();
                teacher.setEmail("admin@example.com");
                teacher.setPassword(passwordEncoder.encode("password"));
                teacher.setFullName("Admin User");
                teacher.setTitle("Head Teacher");
                teacherRepository.save(teacher);
            }
        };
    }
}