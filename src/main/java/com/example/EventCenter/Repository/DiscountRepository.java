package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    // İndirimlere özel sorgular burada tanımlanabilir, örneğin:
    // List<Discount> findByEventId(Long eventId);
}

