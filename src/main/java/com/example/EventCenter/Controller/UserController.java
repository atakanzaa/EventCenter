package com.example.EventCenter.Controller;

import com.example.EventCenter.Dto.UserDto;
import com.example.EventCenter.Dto.UserRegistrationDto;
import com.example.EventCenter.Entity.User;
import com.example.EventCenter.JwtUtil;
import com.example.EventCenter.Service.UserService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;


    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
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


    @GetMapping("/myprofile")
    public ResponseEntity<UserDto> getMyProfile(@RequestHeader("Authorization") String token) {
        try {
            String email = jwtUtil.extractEmail(token.replace("Bearer ", ""));
            UserDto userDto = userService.getUserByEmail(email);
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}





