package com.example.demo.service;

import com.example.demo.dto.TodoListRequestDTO;
import com.example.demo.dto.TodoListResponseDTO;

import java.util.List;

public interface TodoListService {

    // CREATE
    TodoListResponseDTO create(TodoListRequestDTO request);

    // GET ALL
    List<TodoListResponseDTO> getAll();

    // GET BY ID
    TodoListResponseDTO getById(String id);

    // DELETE
    void delete(String id);
}