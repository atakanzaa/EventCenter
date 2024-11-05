package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    // Kullanıcıya özel sorgular burada tanımlanabilir, örneğin:
    // Optional<User> findByEmail(String email);
}

