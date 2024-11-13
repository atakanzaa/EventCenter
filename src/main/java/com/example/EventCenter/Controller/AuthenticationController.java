package com.example.EventCenter.Controller;


import com.example.EventCenter.Dto.LoginRequestDto;
import com.example.EventCenter.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        boolean isAuthenticated = authenticationService.authenticate(loginRequest);
        if (isAuthenticated) {
            return ResponseEntity.ok().body("Giriş başarılı");
        } else {
            return ResponseEntity.status(401).body("Geçersiz e-posta veya parola");
        }
    }
}