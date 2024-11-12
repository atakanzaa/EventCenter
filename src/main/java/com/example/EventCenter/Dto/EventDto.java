package com.example.EventCenter.Dto;
import lombok.Data;


@Data
public class EventDto {
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

}
