package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TaskRequestDTO;
import com.example.demo.dto.TaskResponseDTO;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO request);
    List<TaskResponseDTO> getAllTasks();
    TaskResponseDTO markCompleted(String id);
    void deleteTask(String id);
}