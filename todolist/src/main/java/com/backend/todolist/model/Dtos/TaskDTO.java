package com.backend.todolist.model.Dtos;

import com.backend.todolist.emuns.Priority;
import com.backend.todolist.emuns.TaskStatus;

import jakarta.validation.constraints.NotNull;

public class TaskDTO {
    @NotNull(message = "El título es obligatorio")
    private String title;

    private String description;

    private Priority priority;

    private TaskStatus status;

    
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
