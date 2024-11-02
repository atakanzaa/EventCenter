package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, Long> {
    // Etkinlik kategorilerine özel sorgular burada tanımlanabilir, örneğin:
    // Optional<EventCategory> findByName(String name);
}

