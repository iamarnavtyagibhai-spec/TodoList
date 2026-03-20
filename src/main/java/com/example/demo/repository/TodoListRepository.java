package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.TodoList;

import java.util.List;

public interface TodoListRepository extends MongoRepository<TodoList, String> {
    List<TodoList> findByUserId(String userId);
}