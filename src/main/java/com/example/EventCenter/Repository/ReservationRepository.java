package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Rezervasyonlara özel sorgular burada tanımlanabilir, örneğin:
    // List<Reservation> findByUserId(Long userId);
}

