package com.example.EventCenter.Controller;


import com.example.EventCenter.Dto.LoginRequestDto;
import com.example.EventCenter.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
        String jwtToken = authenticationService.authenticate(loginRequest);
        if (jwtToken != null) {
            Map<String, String> response = new HashMap<>();
            response.put("token", jwtToken);
            return ResponseEntity.ok(response); // Token'i döndür
        } else {
            return ResponseEntity.status(401).body("Geçersiz e-posta veya parola");
        }
    }
}

