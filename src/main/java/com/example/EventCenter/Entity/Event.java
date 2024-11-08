package com.example.EventCenter.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    private String title;
    private String description;
    private String category;
    private String location;
    private LocalDateTime eventDate;
    private String status;
    private LocalDateTime createdAt;
    private Integer maxCapacity;
    private Integer minAge;

    // Getters and Setters
}

