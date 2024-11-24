package com.example.EventCenter.Service;

import com.example.EventCenter.Dto.UserRegistrationDto;
import com.example.EventCenter.Entity.Role;
import com.example.EventCenter.Entity.User;
import com.example.EventCenter.Repository.RoleRepository;
import com.example.EventCenter.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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


    // Tüm kullanıcıları listeleyen metod
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Kullanıcıyı ID'ye göre bulan metod
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
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



    // Kullanıcıyı güncelleme metodunda şifreyi hash'leme
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            // Kullanıcı bilgilerini güncelliyoruz
            user.setName(userDetails.getName());
            user.setSurname(userDetails.getSurname());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setRole(userDetails.getRole());
            user.setBirthDate(userDetails.getBirthDate());
            user.setIsApproved(userDetails.getIsApproved());

            // Eğer yeni şifre verilmişse, onu hash'liyoruz
            if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
                String encodedPassword = passwordEncoder.encode(userDetails.getPassword());
                user.setPassword(encodedPassword);  // Hashlenmiş yeni şifreyi kullanıcıya atıyoruz
            }

            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
