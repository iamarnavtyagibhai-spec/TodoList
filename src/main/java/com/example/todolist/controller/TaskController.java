package com.example.todolist.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.Task;
import com.example.todolist.response.ApiResponse;
import com.example.todolist.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    // ✅ Create Task
    @PostMapping
    public ApiResponse<Task> create(@RequestBody Task task, Principal principal) {

        task.setUserEmail(principal.getName()); // 🔥 IMPORTANT

        Task saved = service.create(task);

        return new ApiResponse<>(
                true,
                saved,
                "Task created successfully"
        );
    }

    // ✅ Get Tasks by listId
    @GetMapping("/{listId}")
    public ApiResponse<List<Task>> getByList(@PathVariable String listId,
                                            Principal principal) {

        String email = principal.getName();

        List<Task> tasks = service.getByListAndUser(listId, email);

        return new ApiResponse<>(
                true,
                tasks,
                "Tasks fetched successfully"
        );
    }

    // ✅ Toggle Task
    @PutMapping("/{taskId}/toggle")
    public ApiResponse<Task> toggle(@PathVariable String taskId,
                                   Principal principal) {

        String email = principal.getName();

        Task updated = service.toggle(taskId, email);

        return new ApiResponse<>(
                true,
                updated,
                "Task status updated"
        );
    }

    // ✅ Delete Task
    @DeleteMapping("/{taskId}")
    public ApiResponse<String> delete(@PathVariable String taskId,
                                     Principal principal) {

        String email = principal.getName();

        service.delete(taskId, email);

        return new ApiResponse<>(
                true,
                null,
                "Task deleted successfully"
        );
    }
}