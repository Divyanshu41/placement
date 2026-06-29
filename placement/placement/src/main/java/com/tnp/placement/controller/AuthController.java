package com.tnp.placement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.tnp.placement.model.Student;
import com.tnp.placement.model.Recruiter;
import com.tnp.placement.repository.StudentRepository;
import com.tnp.placement.repository.RecruiterRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RecruiterRepository recruiterRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        // Temporary: accept any credentials and return a fake token
        String role = payload.getOrDefault("role", "student");
        String username = payload.getOrDefault("username", "user");
        String token = "dummy-token-" + role + "-" + username;
        return ResponseEntity.ok(Map.of(
                "token", token,
                "role", role,
                "username", username));
    }

    @PostMapping("/register/student")
    public ResponseEntity<?> registerStudent(@RequestBody Map<String, String> payload) {
        try {
            String name = payload.getOrDefault("name", "");
            String email = payload.getOrDefault("email", "");
            // String password = payload.getOrDefault("password", "");
            String branch = payload.getOrDefault("branch", "");
            double cgpa = Double.parseDouble(payload.getOrDefault("cgpa", "0"));
            if (studentRepository.findAll().stream().anyMatch(s -> s.getEmail().equals(email))) {
                return ResponseEntity.badRequest().body(Map.of("message", "Email already registered"));
            }
            Student student = new Student(name, email, branch, cgpa);
            // Save password as encoded in a new field (not present in model, so just for
            // demo)
            // In real app, add password field to Student model
            studentRepository.save(student);
            return ResponseEntity.ok(Map.of("message", "Student registered successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/register/recruiter")
    public ResponseEntity<?> registerRecruiter(@RequestBody Map<String, String> payload) {
        try {
            String name = payload.getOrDefault("name", "");
            String email = payload.getOrDefault("email", "");
            // String password = payload.getOrDefault("password", "");
            String company = payload.getOrDefault("company", "");
            if (recruiterRepository.findAll().stream().anyMatch(r -> r.getEmail().equals(email))) {
                return ResponseEntity.badRequest().body(Map.of("message", "Email already registered"));
            }
            Recruiter recruiter = new Recruiter(name, company, email);
            // Save password as encoded in a new field (not present in model, so just for
            // demo)
            // In real app, add password field to Recruiter model
            recruiterRepository.save(recruiter);
            return ResponseEntity.ok(Map.of("message", "Recruiter registered successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/register/tpo")
    public ResponseEntity<?> registerTpo(@RequestBody Map<String, String> payload) {
        // For demo, just return success (TPO registration logic can be extended)
        return ResponseEntity.ok(Map.of("message", "TPO registered successfully (demo)"));
    }
}
