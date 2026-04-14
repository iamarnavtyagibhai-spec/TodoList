package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.todolist.model.TodoList;

public interface TodoListRepository extends MongoRepository<TodoList, String> {

    List<TodoList> findByUserEmail(String email);

    List<TodoList> findByUserEmailAndDate(String email, String date);
}