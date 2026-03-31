package com.example.demo.controller;

import com.example.demo.dto.TodoListRequestDTO;
import com.example.demo.dto.TodoListResponseDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.TodoListService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {

    private final TodoListService service;

    // Constructor Injection ✅
    public TodoListController(TodoListService service) {
        this.service = service;
    }

    // ================= CREATE =================
    @PostMapping
    public ResponseEntity<ApiResponse<TodoListResponseDTO>> create(
            @RequestBody TodoListRequestDTO request) {

        TodoListResponseDTO response = service.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, response, "Todo list created successfully"));
    }

    // ================= GET ALL =================
    @GetMapping
    public ResponseEntity<ApiResponse<List<TodoListResponseDTO>>> getAll() {

        List<TodoListResponseDTO> response = service.getAll();

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Todo lists fetched successfully"));
    }

    // ================= GET BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoListResponseDTO>> getById(
            @PathVariable String id) {

        TodoListResponseDTO response = service.getById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Todo list fetched successfully"));
    }

    // ================= UPDATE =================
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoListResponseDTO>> update(
            @PathVariable String id,
            @RequestBody TodoListRequestDTO request) {

        TodoListResponseDTO response = service.update(id, request);

        return ResponseEntity.ok(
                new ApiResponse<>(true, response, "Todo list updated successfully"));
    }

    // ================= DELETE =================
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable String id) {

        service.delete(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, null, "Todo list deleted successfully"));
    }
}