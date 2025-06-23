package com.backend.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.todolist.model.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {
    
}
