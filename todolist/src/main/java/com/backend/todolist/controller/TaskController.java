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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @Operation(summary = "Crear una nueva tarea")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tarea creada correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    // Crear una tarea
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        Task createdTask = taskService.createTask(taskDTO);
        return ResponseEntity.ok(createdTask);
    }

    @Operation(summary = "Actualizar una tarea por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tarea actualizada correctamente"),
        @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })

    // Actualizar tarea por id
    @PutMapping("/update/{id}")
    public ResponseEntity<Task>  updateTask(@PathVariable Long id,@Valid @RequestBody TaskDTO taskDTO){
        Task updateTask = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updateTask);
    }
    
    @Operation(summary = "Obtener todas las tareas")
    @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida correctamente")

    // Obtener Todas las Tareas
    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(summary = "Obtener tarea por id")
    @ApiResponse(responseCode = "200", description = "Tarea Encontrada")
    @ApiResponse(responseCode = "404", description = "Tarea no Encontrada")
    //Obtener tarea por id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task getTaskById = taskService.getTaskById(id);
        return ResponseEntity.ok(getTaskById);
    }

    @Operation(summary = "Eliminar tarea por id")
    @ApiResponse(responseCode = "204" , description = "Tarea Eliminada Corectamente")
    @ApiResponse(responseCode = "404", description = "Tarea no Encontrada")
    // Eliminar Tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
