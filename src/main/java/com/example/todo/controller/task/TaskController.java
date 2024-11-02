package com.example.todo.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String list(Model model){

        var task = new TaskDTO(1L, "Shopping", "detail", "todo");
        var task2 = new TaskDTO(2L, "Reading", "detail", "todo");
        var tasks = List.of(task, task2);
        model.addAttribute("tasks", tasks);

        return "tasks/list";
    }
}
