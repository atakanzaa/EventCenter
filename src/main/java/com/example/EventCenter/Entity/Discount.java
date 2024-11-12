package com.example.EventCenter.Entity;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discountId; // Bu alan primary key olarak ayarlandı

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    private BigDecimal discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;

    // Getters ve Setters
}
