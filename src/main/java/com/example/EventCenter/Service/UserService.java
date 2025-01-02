package com.example.EventCenter.Service;

import com.example.EventCenter.Dto.UserDto;
import com.example.EventCenter.Dto.UserRegistrationDto;
import com.example.EventCenter.Entity.Role;
import com.example.EventCenter.Entity.User;
import com.example.EventCenter.Repository.RoleRepository;
import com.example.EventCenter.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    @Autowired
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + email));
        return new UserDto(user.getName(), user.getSurname(), user.getEmail(), user.getPhoneNumber(), user.getBirthDate());
    }

    public User createUser(UserRegistrationDto userRegistrationDto) {
        // Aynı e-posta ile kayıtlı kullanıcı var mı kontrolü
        if (userRepository.existsByEmail(userRegistrationDto.getEmail())) {
            throw new IllegalArgumentException("Bu e-posta ile zaten bir kullanıcı kayıtlı.");
        }

        // DTO'dan User entity'si oluşturma
        User user = new User();
        user.setName(userRegistrationDto.getName());
        user.setSurname(userRegistrationDto.getSurname());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword())); // BCrypt ile şifreleme
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        //user.setRole(userRegistrationDto.getRole());
        user.setBirthDate(userRegistrationDto.getBirthDate());
        user.setCreatedAt(LocalDateTime.now());

        Role userRole = roleRepository.findByid(3L);

        user.getRoles().add(userRole);
        userRepository.save(user);
        return user;
    }


}
