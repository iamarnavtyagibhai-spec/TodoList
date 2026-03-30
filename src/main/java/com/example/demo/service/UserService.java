package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;


public interface UserService {

    UserResponseDTO createUser(UserRequestDTO request);

   
}