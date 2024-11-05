package com.example.EventCenter.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountDTO {
    private Long discountId;
    private Long eventId;
    private Long ticketId;
    private Double discountPercentage;
    private String startDate;
    private String endDate;

    // Getter ve Setter'lar
}

