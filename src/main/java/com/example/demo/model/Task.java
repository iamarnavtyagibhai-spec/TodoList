package com.example.demo.model;


import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    private String title;
    private String TodoList;
    private String description;
    private LocalDate dueDate;

    private Boolean isCompleted = false;

    private String todoListId;

    private Instant createdAt = Instant.now();
}