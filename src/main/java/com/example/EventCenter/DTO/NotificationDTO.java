package com.example.EventCenter.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {
    private Long notificationId;
    private Long userId;
    private String message;
    private String sentAt;
    private String type;

    // Getter ve Setter'lar
}

