package com.example.demo.controller;

import com.example.demo.dto.TaskRequestDTO;
import com.example.demo.dto.TaskResponseDTO;
import com.example.demo.service.TaskService;
import com.example.demo.response.ApiResponse;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // Constructor Injection ✅
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // ================= CREATE =================
    @PostMapping("/{listId}")
    public ResponseEntity<ApiResponse<TaskResponseDTO>> createTask(
            @PathVariable String listId,
            @RequestBody TaskRequestDTO request) {

        TaskResponseDTO response = taskService.create(listId, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, response, "Task created successfully"));
    }

    // ================= GET TASKS BY LIST =================
    @GetMapping("/list/{listId}")
    public ResponseEntity<ApiResponse<List<TaskResponseDTO>>> getTasksByList(
            @PathVariable String listId) {

        List<TaskResponseDTO> response = taskService.getByList(listId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Tasks fetched successfully"));
    }

    // ================= SEARCH TASK =================
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<TaskResponseDTO>>> searchTask(
            @RequestParam String keyword) {

        List<TaskResponseDTO> response = taskService.search(keyword);

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Search results"));
    }

    // ================= MARK COMPLETE =================
    @PutMapping("/complete/{taskId}")
    public ResponseEntity<ApiResponse<TaskResponseDTO>> completeTask(
            @PathVariable String taskId) {

        TaskResponseDTO response = taskService.markComplete(taskId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Task marked as complete"));
    }
}