package com.example.EventCenter.Dto;

import lombok.Data;


@Data
public class TicketDto {
    private Long ticketId;
    private Long eventId;
    private String ticketType;
    private Double price;
    private Integer quantity;

    // Getter ve Setter'lar
}

