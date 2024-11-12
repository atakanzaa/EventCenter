package com.example.EventCenter.Dto;

import lombok.Data;


@Data
public class PaymentDto {
    private Long paymentId;
    private Long reservationId;
    private Long userId;
    private Double amount;
    private String paymentDate;
    private String paymentMethod;
    private String status;

    // Getter ve Setter'lar
}

