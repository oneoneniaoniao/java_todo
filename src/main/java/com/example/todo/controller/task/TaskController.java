package com.example.todo.controller.task;

import com.example.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String list(Model model) {
        var tasks = taskService.find()
                .stream()
                .map(TaskDTO::toDTO
                )
                .toList();

        model.addAttribute("tasks", tasks);
        return "tasks/list";
    }
    @GetMapping("/tasks/{id}")
    public String showDetail(@PathVariable("id") long taskId, Model model){
        model.addAttribute("taskId", taskId);
        var taskEntity = taskService.findById(taskId)
                .orElseThrow(()->new IllegalArgumentException("Task not found: id = "+ taskId));
        model.addAttribute("task", TaskDTO.toDTO(taskEntity));
        return "tasks/detail";
    }
}

