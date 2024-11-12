package com.example.EventCenter.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "event_categories")
public class EventCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;
    private String description;

    // Getters and Setters
}
