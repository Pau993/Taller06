package com.example.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordHashRepository extends JpaRepository<PasswordHash, Long> {
}