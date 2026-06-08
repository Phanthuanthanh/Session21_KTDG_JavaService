package com.example.base_spring_boot.models.repositories;

import com.example.base_spring_boot.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
