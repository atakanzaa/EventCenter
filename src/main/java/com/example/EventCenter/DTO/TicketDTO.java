package com.example.EventCenter.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    private Long ticketId;
    private Long eventId;
    private String ticketType;
    private Double price;
    private Integer quantity;

    // Getter ve Setter'lar
}

