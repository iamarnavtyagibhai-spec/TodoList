package com.example.demo.model;


import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todolists")
public class TodoList {

    @Id
    private String id;

    private String title;
    private String userId;

    private Instant createdAt = Instant.now();
}