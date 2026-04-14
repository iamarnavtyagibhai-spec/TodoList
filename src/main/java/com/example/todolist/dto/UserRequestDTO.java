package com.example.todolist.dto;
import lombok.*;

@Data
@NoArgsConstructor  
@AllArgsConstructor
public class UserRequestDTO {

    private String name;
    private String email;

}