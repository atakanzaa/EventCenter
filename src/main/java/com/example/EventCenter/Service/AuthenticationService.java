package com.example.EventCenter.Service;

import com.example.EventCenter.Dto.LoginRequestDto;
import com.example.EventCenter.Entity.User;
import com.example.EventCenter.JwtUtil;
import com.example.EventCenter.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();

        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String storedPasswordHash = user.getPassword();

            return passwordEncoder.matches(password, storedPasswordHash);
        }
        return false;
    }
}

