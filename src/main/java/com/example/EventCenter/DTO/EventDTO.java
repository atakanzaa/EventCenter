package com.example.EventCenter.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {
    private Long eventId;
    private Long organizerId;
    private String title;
    private String description;
    private String category;
    private String location;
    private String eventDate;
    private String status;
    private Integer maxCapacity;
    private Integer minAge;

    // Getter ve Setter'lar
}
