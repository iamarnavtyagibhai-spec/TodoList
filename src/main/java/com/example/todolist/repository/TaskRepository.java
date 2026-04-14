package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.todolist.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByListIdAndUserEmail(String listId, String userEmail);
}