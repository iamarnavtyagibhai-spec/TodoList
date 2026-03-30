package com.example.demo.service;

import com.example.demo.dto.*;
import java.util.List;

public interface TaskService {

    TaskResponseDTO create(String listId, TaskRequestDTO request);

    List<TaskResponseDTO> getByList(String listId);

    List<TaskResponseDTO> search(String keyword);

    TaskResponseDTO markComplete(String taskId);
}