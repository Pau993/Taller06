package com.example.Controller;

import com.example.customer.UserDto;
import com.example.customer.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
}