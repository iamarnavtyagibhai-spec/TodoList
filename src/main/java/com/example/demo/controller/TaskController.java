package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TaskRequestDTO;
import com.example.demo.dto.TaskResponseDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ApiResponse<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO request) {
        return new ApiResponse<>(
                true,
                taskService.createTask(request),
                "Task created successfully"
        );
    }

    @GetMapping
    public ApiResponse<List<TaskResponseDTO>> getAllTasks() {
        return new ApiResponse<>(
                true,
                taskService.getAllTasks(),
                null
        );
    }

    @PutMapping("/{id}/complete")
    public ApiResponse<TaskResponseDTO> complete(@PathVariable String id) {
        return new ApiResponse<>(
                true,
                taskService.markCompleted(id),
                "Task marked completed"
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        taskService.deleteTask(id);
        return new ApiResponse<>(true, null, "Task deleted");
    }
}