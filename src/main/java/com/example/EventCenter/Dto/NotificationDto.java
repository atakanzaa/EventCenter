package com.example.EventCenter.Dto;

import lombok.Data;

@Data
public class NotificationDto {
    private Long notificationId;
    private Long userId;
    private String message;
    private String sentAt;
    private String type;

    // Getter ve Setter'lar
}

