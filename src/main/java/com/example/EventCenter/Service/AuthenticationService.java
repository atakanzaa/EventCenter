package com.example.EventCenter.Service;

import com.example.EventCenter.Dto.LoginRequestDto;
import com.example.EventCenter.Entity.User;
import com.example.EventCenter.JwtUtil;
import com.example.EventCenter.Repository.RoleRepository;
import com.example.EventCenter.Repository.UserRepository;
import com.example.EventCenter.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public Map<String, Object> authenticate(LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();

        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String storedPasswordHash = user.getPassword();

            if (passwordEncoder.matches(password, storedPasswordHash)) {
                String token = jwtUtil.generateToken(email);
                Long userId = user.getUserId();
                Long roleId = userRoleRepository.findRoleIdByUserId(userId);
                String roleName = roleRepository.findRoleNameById(roleId);

                // Yanıt için bilgileri hazırlayın
                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("role", roleName);
                return response;
            }
        }
        return null;
    }
}



