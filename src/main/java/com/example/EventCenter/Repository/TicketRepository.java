package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Biletlere özel sorgular burada tanımlanabilir, örneğin:
    // List<Ticket> findByEventId(Long eventId);
}

