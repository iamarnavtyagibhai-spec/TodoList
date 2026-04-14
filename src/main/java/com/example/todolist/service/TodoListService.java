package com.example.todolist.service;

import java.util.List;

import com.example.todolist.model.TodoList;

public interface TodoListService {

    TodoList create(TodoList todo);

    List<TodoList> getByUser(String email);

    List<TodoList> getByUserAndDate(String email, String date);
}