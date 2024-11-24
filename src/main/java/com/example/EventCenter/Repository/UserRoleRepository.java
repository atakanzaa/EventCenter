package com.example.EventCenter.Repository;


import com.example.EventCenter.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT role_id FROM user_roles WHERE user_id = :userId", nativeQuery = true)
    Long findRoleIdByUserId(@Param("userId") Long userId);
}
