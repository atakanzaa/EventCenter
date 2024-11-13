package com.example.EventCenter.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String surname;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String phoneNumber;
    private String role;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    private String profilePictureUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthDate;

    private Boolean isApproved = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",  // user_roles tablosunu kullanacağız
            joinColumns = @JoinColumn(name = "user_id"), // user_id sütunu
            inverseJoinColumns = @JoinColumn(name = "role_id") // role_id sütunu
    )
    private Set<Role> roles = new HashSet<>();
}


