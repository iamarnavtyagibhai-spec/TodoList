package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repo;

    @Override
    public Task create(Task task) {

        // 🔥 default completed = false
        if (task.getCompleted() == null) {
            task.setCompleted(false);
        }

        return repo.save(task);
    }

    @Override
    public List<Task> getByListAndUser(String listId, String email) {
        return repo.findByListIdAndUserEmail(listId, email);
    }

    @Override
    public Task toggle(String taskId, String email) {

        Task task = repo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // 🔥 security check
        if (!task.getUserEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }

        task.setCompleted(!task.getCompleted());

        return repo.save(task);
    }

    @Override
    public void delete(String taskId, String email) {

        Task task = repo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getUserEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }

        repo.deleteById(taskId);
    }

    @Override
    public Task update(String taskId,String newTitle, String email){
      Task task = repo.findById(taskId)
        .orElseThrow(() -> new RuntimeException("Task not found"));
           if (!task.getUserEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }
        task.setTitle(newTitle);
        return repo.save(task);

    }
}