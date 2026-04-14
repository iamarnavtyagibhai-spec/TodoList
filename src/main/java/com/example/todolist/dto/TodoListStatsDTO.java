package com.example.todolist.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListStatsDTO {

    private String listId;
    private String title;
    private LocalDate date;

    private int totalTasks;
    private int completedTasks;
    private double completionPercentage;

    // getters & setters
}