package com.backend.todolist.service;

import java.util.List;

import com.backend.todolist.model.Task;
import com.backend.todolist.model.Dtos.TaskDTO;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task createTask(TaskDTO taskDTO);

    Task updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);
}
