package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.model.TodoList;
import com.example.todolist.repository.TodoListRepository;

@Service
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    private TodoListRepository repo;

    @Override
    public TodoList create(TodoList todo) {
        return repo.save(todo);
    }

    @Override
    public List<TodoList> getByUser(String email) {
        return repo.findByUserEmail(email);
    }

    @Override
    public List<TodoList> getByUserAndDate(String email, String date) {
        return repo.findByUserEmailAndDate(email, date);
    }
}