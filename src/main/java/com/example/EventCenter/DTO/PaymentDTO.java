package com.example.EventCenter.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    private Long paymentId;
    private Long reservationId;
    private Long userId;
    private Double amount;
    private String paymentDate;
    private String paymentMethod;
    private String status;

    // Getter ve Setter'lar
}

