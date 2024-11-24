package com.example.EventCenter.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "event_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, unique = true) // Kategori adı benzersiz olsun
    private String name;
    private String description;

    @ManyToMany(mappedBy = "event_categories")
    private Set<Event> events = new HashSet<>();

    // Getters and Setters
}
