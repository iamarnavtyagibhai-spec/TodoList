package com.example.demo.repository;

import com.example.demo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    // 🔥 Get all tasks of a specific TodoList
    List<Task> findByTodoListId(String todoListId);

    // 🔍 Search tasks by title
    List<Task> findByTitleContainingIgnoreCase(String keyword);
}