package com.backend.todolist.model.Dtos;

import java.time.LocalDateTime;

import com.backend.todolist.emuns.Priority;
import com.backend.todolist.emuns.TaskStatus;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para crear o actualizar tareas")
public class TaskDTO {

    @Schema(description = "Título de la tarea", example = "Estudiar Swagger")
    @NotNull(message = "El título es obligatorio")
    private String title;

    @Schema(description = "Descripción detallada de la tarea", example = "Revisar las anotaciones de OpenAPI en Spring Boot")
    private String description;

    @Schema(description = "Nivel de prioridad de la tarea", example = "HIGH")
    private Priority priority;

    @Schema(description = "Estado actual de la tarea", example = "PENDING")
    private TaskStatus status;

    @Schema(description = "Fecha de la última actualización de la tarea (opcional)", example = "2024-06-22T14:30:00")
    private LocalDateTime updatedAt;

    // Getters y Setters
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
