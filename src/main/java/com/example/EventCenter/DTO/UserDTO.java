package com.example.EventCenter.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String role;
    private String profilePictureUrl;
    private String birthdate;
    private Boolean isApproved;

    // Getter ve Setter'lar
}
