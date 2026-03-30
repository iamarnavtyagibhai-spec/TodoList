package com.example.demo.controller;

import com.example.demo.dto.TodoListRequestDTO;
import com.example.demo.dto.TodoListResponseDTO;
import com.example.demo.service.TodoListService;
import com.example.demo.response.ApiResponse;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {

    private final TodoListService todoListService;

    // Constructor Injection ✅
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    // ================= CREATE =================
    @PostMapping
    public ResponseEntity<ApiResponse<TodoListResponseDTO>> create(
            @RequestBody TodoListRequestDTO request) {

        TodoListResponseDTO response = todoListService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, response, "Todo list created successfully"));
    }

    // ================= GET ALL =================
    @GetMapping
    public ResponseEntity<ApiResponse<List<TodoListResponseDTO>>> getAll() {

        List<TodoListResponseDTO> response = todoListService.getAll();

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Todo lists fetched successfully"));
    }

    // ================= GET BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoListResponseDTO>> getById(
            @PathVariable String id) {

        TodoListResponseDTO response = todoListService.getById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Todo list fetched successfully"));
    }

    // ================= DELETE =================
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id) {

        todoListService.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, null, "Todo list deleted successfully"));
    }
}