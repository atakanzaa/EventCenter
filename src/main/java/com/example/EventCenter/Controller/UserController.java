package com.example.EventCenter.Controller;

import com.example.EventCenter.Dto.UserRegistrationDto;
import com.example.EventCenter.Entity.User;
import com.example.EventCenter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        try {
            userService.createUser(userRegistrationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Kullanıcı başarıyla kaydedildi.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Kullanıcı kaydedilemedi.");
        }
    }
}


