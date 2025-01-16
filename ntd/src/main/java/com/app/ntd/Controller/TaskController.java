package com.app.ntd.Controller;

import com.app.ntd.Service.TaskService;
import com.app.ntd.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String findalltask(Model model){
        List<Task> tasks= taskService.findAll();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String ADDTask(@RequestParam String title){
        taskService.Addtask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String removeTask(@PathVariable Long id){
        taskService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/{toggle}")
    public String Toggletask(@PathVariable Long id){
        taskService.toggle(id);
        return "redirect:/";
    }


}
