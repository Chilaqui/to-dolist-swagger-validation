package com.backend.todolist.service;

import java.util.List;

import com.backend.todolist.model.Task;
import com.backend.todolist.model.Dtos.TaskDTO;

public interface TaskService {

     //Crear Tarea
    Task createTask(TaskDTO taskDTO);

    //Modifiacar tarea por id
    Task updateTask(Long id, TaskDTO taskDTO);

    //Obtener todas las tareas
    List<Task> getAllTasks();

    //Obtener tarea por id
    Task getTaskById(Long id);

    //Eliminar tarea
    void deleteTask(Long id);
}
