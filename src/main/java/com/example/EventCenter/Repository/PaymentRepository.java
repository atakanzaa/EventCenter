package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Ödeme işlemlerine özel sorgular burada tanımlanabilir, örneğin:
    // List<Payment> findByStatus(String status);
}

