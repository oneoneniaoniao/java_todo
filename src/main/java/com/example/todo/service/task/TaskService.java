package com.example.todo.service.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    public List<TaskEntity> find(){
        var task = new TaskEntity(1L, "Shopping", "detail?", TaskStatus.TODO);
        var task2 = new TaskEntity(2L, "Reading", "detail", TaskStatus.TODO);
        return List.of(task, task2);

    }
}
