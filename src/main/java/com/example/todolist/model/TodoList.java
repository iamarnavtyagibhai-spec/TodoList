package com.example.todolist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "todolists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {

    @Id
    private String id;

    private String title;

    private String date; // ✅ NEW (YYYY-MM-DD)

    private String userEmail; // optional (recommended)
}