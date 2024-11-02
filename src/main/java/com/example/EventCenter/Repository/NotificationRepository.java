package com.example.EventCenter.Repository;

import com.example.EventCenter.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Bildirimlere özel sorgular burada tanımlanabilir, örneğin:
    // List<Notification> findByUserId(Long userId);
}
