package com.example.EventCenter.Dto;

import lombok.Data;


@Data
public class ReservationDto {
    private Long reservationId;
    private Long userId;
    private Long eventId;
    private Long ticketId;
    private String reservationDate;
    private String status;

    // Getter ve Setter'lar
}

