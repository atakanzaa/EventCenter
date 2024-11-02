package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Etkinliklere özel sorgular burada tanımlanabilir, örneğin:
    // List<Event> findByStatus(String status);
}

