package com.example.todolist.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor  
@AllArgsConstructor
public class UserResponseDTO {

    private String id;
    private String name;
    private String email;
    private String password;
}