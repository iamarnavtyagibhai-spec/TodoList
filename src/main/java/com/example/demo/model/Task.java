package com.example.demo.model;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "tasks")
@Data
public class Task {

    @Id
    private String id;

    private String todoListId;

    private String title;
    private String description;
    private LocalDate dueDate;

    private boolean isCompleted;
    private Instant createdAt;

    // getters & setters
}