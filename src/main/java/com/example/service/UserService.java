package com.example.service;

import com.example.customer.User;
import com.example.customer.PasswordHash;
import com.example.customer.UserDto;
import com.example.customer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User createUser(UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getEmail());
        PasswordHash passwordHash = new PasswordHash(user, userDto.getPassword());
        user.setPasswordHash(passwordHash);

        return userRepository.save(user);
    }
}