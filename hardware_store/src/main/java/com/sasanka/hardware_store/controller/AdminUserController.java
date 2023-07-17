package com.sasanka.hardware_store.controller;

import com.sasanka.hardware_store.Document.Admin;
import com.sasanka.hardware_store.Document.AdminCredentials;
import com.sasanka.hardware_store.Repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminUserController {
    private  final AdminUserRepository adminRepository;

    String secretKey = "ThisIsASecretKey";

    @Autowired
    public AdminUserController(AdminUserRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminCredentials credentials) throws Exception {
        Admin admin = adminRepository.findByUsername(credentials.getUsername());
        if (admin != null && admin.getPassword().equals(credentials.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
