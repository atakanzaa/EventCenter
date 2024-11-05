package com.example.EventCenter.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    private Long reservationId;
    private Long userId;
    private Long eventId;
    private Long ticketId;
    private String reservationDate;
    private String status;

    // Getter ve Setter'lar
}

