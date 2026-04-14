package com.example.todolist.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.User;
import com.example.todolist.response.ApiResponse;
import com.example.todolist.security.JwtUtil;
import com.example.todolist.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ApiResponse<User> register(@RequestBody User user) {
        return new ApiResponse<>(
                true,
                service.register(user),
                "User registered successfully"
        );
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody User user) {
        String token = jwtUtil.generateToken(user.getEmail());

        return new ApiResponse<>(
                true,
                token,
                "Login successful"
        );
    }
}