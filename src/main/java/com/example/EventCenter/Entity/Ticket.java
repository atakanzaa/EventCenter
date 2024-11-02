package com.example.EventCenter.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String ticketType;
    private BigDecimal price;
    private Integer quantity;
    private LocalDateTime createdAt;

    // Getters and Setters
}
