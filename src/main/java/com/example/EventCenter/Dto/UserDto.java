package com.example.EventCenter.Dto;

import lombok.Data;


@Data
public class UserDto {
    private Long userId;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String role;
    private String profilePictureUrl;
    private String birthDate;
    private Boolean isApproved;

    // Getter ve Setter'lar
}
