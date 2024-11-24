package com.example.EventCenter.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
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
    private String categoryName;
    private String location;
    private LocalDateTime eventDate;
    private String status;
    private LocalDateTime createdAt;
    private Integer maxCapacity;
    private Integer minAge;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "event_category",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> event_categories = new HashSet<>();


    // Getters and Setters
}

