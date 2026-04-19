package com.example.todolist.service;

import java.util.List;

import com.example.todolist.model.Task;

public interface TaskService {

    Task create(Task task);

    List<Task> getByListAndUser(String listId, String email);

    Task toggle(String taskId, String email);

    void delete(String taskId, String email);
    Task update(String taskId,String newTitle, String email);
 
}