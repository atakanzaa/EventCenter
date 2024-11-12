package com.example.EventCenter.Controller;

import com.example.EventCenter.Dto.UserRegistrationDto;
import com.example.EventCenter.Entity.User;
import com.example.EventCenter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
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
    public ResponseEntity<User> getUserProfile() {
        User user = userService.getCurrentUser();  // Kullanıcıyı al
        if (user != null) {
            return ResponseEntity.ok(user);  // Kullanıcı varsa, bilgileri döndür
        } else {
            return ResponseEntity.status(404).build();  // Kullanıcı bulunamazsa 404 döner
        }
    }
        // Belirli bir userId ile kullanıcı bilgisi döndürme
    @GetMapping("/{userId}")
        public ResponseEntity<User> getUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }


    }
