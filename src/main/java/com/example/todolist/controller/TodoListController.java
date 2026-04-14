package com.example.todolist.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.todolist.model.TodoList;
import com.example.todolist.response.ApiResponse;
import com.example.todolist.service.*;

@RestController
@RequestMapping("/lists")
public class TodoListController {

    @Autowired
    private TodoListService service;

    @PostMapping
    public ApiResponse<TodoList> create(@RequestBody TodoList list, Principal principal) {

        list.setUserEmail(principal.getName());

        if (list.getDate() == null) {
            list.setDate(LocalDate.now().toString());
        }

        TodoList saved = service.create(list);

        return new ApiResponse<>(true, saved, "List created successfully");
    }

    @GetMapping
    public ApiResponse<List<TodoList>> getAll(Principal principal) {

        String email = principal.getName();
        List<TodoList> lists = service.getByUser(email);

        return new ApiResponse<>(true, lists, "All lists fetched");
    }

    @GetMapping("/date/{date}")
    public ApiResponse<List<TodoList>> getByDate(@PathVariable String date,
                                                Principal principal) {

        String email = principal.getName();
        List<TodoList> lists = service.getByUserAndDate(email, date);

        return new ApiResponse<>(true, lists, "Lists by date fetched");
    }
}