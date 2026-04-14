package com.example.todolist.dto;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListResponseDTO {
    private String id;
    private String title;
    private Instant createdAt;
    
}