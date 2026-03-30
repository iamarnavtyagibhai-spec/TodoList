package com.example.demo.service;

import com.example.demo.dto.TodoListRequestDTO;
import com.example.demo.dto.TodoListResponseDTO;
import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    private TodoListRepository repository;

    // ✅ CREATE
    @Override
    public TodoListResponseDTO create(TodoListRequestDTO request) {

        TodoList list = new TodoList();
        list.setTitle(request.getTitle());
        list.setCreatedAt(Instant.now());  // set time

        TodoList saved = repository.save(list);

        return map(saved);
    }

    // ✅ GET ALL
    @Override
    public List<TodoListResponseDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(n -> map(n))
                .toList();
    }

    // ✅ GET BY ID
    @Override
    public TodoListResponseDTO getById(String id) {

        TodoList list = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        return map(list);
    }

    // ✅ DELETE
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    // 🔥 COMMON METHOD (convert Entity → DTO)
    private TodoListResponseDTO map(TodoList list) {

        TodoListResponseDTO dto = new TodoListResponseDTO();

        dto.setId(list.getId());
        dto.setTitle(list.getTitle());
        dto.setCreatedAt(list.getCreatedAt());

        return dto;
    }
}