package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repo;

    // ================= CREATE TASK =================
    @Override
    public TaskResponseDTO create(String listId, TaskRequestDTO request) {

        Task task = new Task();

        task.setTodoListId(listId);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
        task.setCompleted(false);
        task.setCreatedAt(Instant.now());

        Task savedTask = repo.save(task);

        return map(savedTask);
    }

    // ================= GET TASKS BY LIST =================
    @Override
    public List<TaskResponseDTO> getByList(String listId) {

        return repo.findByTodoListId(listId)
                .stream()
                .map(n -> map(n))   // using lambda
                .toList();
    }

    // ================= SEARCH TASK =================
    @Override
    public List<TaskResponseDTO> search(String keyword) {

        return repo.findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(n -> map(n))   // using lambda
                .toList();
    }

    // ================= MARK COMPLETE =================
    @Override
    public TaskResponseDTO markComplete(String taskId) {

        Task task = repo.findById(taskId).orElseThrow();

        task.setCompleted(true);

        Task updatedTask = repo.save(task);

        return map(updatedTask);
    }

    // ================= MAP FUNCTION =================
    private TaskResponseDTO map(Task t) {

        TaskResponseDTO dto = new TaskResponseDTO();

        dto.setId(t.getId());
        dto.setTitle(t.getTitle());
        dto.setDescription(t.getDescription());
        dto.setCompleted(t.isCompleted());
        dto.setCreatedAt(t.getCreatedAt());
        dto.setDueDate(t.getDueDate());

        return dto;
    }
}