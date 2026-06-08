package com.example.base_spring_boot.models.repositories;

import com.example.base_spring_boot.models.entities.RefreshToken;
import com.example.base_spring_boot.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    int deleteByUser(User user);
}
