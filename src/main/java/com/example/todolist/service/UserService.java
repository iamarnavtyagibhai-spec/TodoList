package com.example.todolist.service;

import com.example.todolist.model.User;
import java.util.Optional;

public interface UserService {

    User register(User user);

    Optional<User> findByEmail(String username);
}