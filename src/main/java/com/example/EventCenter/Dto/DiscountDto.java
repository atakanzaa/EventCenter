package com.example.EventCenter.Dto;


import lombok.Data;

@Data
public class DiscountDto {
    private Long discountId;
    private Long eventId;
    private Long ticketId;
    private Double discountPercentage;
    private String startDate;
    private String endDate;

    // Getter ve Setter'lar
}

