package com.example.customer;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class PasswordHash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String hashedPassword;

    public PasswordHash() {}

    public PasswordHash(User user, String rawPassword) {
        this.user = user;
        this.hashedPassword = hashPassword(rawPassword);
    }

    private String hashPassword(String rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}