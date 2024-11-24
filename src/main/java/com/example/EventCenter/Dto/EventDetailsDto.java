package com.example.EventCenter.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class EventDetailsDto {
    private Long eventId;
    private String title;
    private String description;
    private Long categoryId;  // Frontend'den gelen kategori id
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventDate;
    private String status;
    private Integer maxCapacity;
    private Integer minAge;
    private String categoryName;

    // getters and setters
}
