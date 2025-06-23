package com.backend.todolist.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.todolist.model.Task;
import com.backend.todolist.model.Dtos.TaskDTO;
import com.backend.todolist.service.TaskService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Crear una tarea
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        Task createdTask = taskService.createTask(taskDTO);
        return ResponseEntity.ok(createdTask);
    }

    // Actualizar tarea por id
    @PutMapping("/update/{id}")
    public ResponseEntity<Task>  updateTask(@PathVariable Long id,@Valid @RequestBody TaskDTO taskDTO){
        Task updateTask = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updateTask);
    }
    
    // Obtener Todas las Tareas

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    //Obtener tarea por id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task getTaskById = taskService.getTaskById(id);
        return ResponseEntity.ok(getTaskById);
    }

    // Eliminar Tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
