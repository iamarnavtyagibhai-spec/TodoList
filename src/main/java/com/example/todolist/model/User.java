package com.example.todolist.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="user")
public class User {
    @Id
    private String id;

    private String name;
    private String email;
    private String password;

    private Instant createdAt = Instant.now();

}
