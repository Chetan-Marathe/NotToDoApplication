package com.app.ntd.Service;

import com.app.ntd.Repository.TaskRepository;
import com.app.ntd.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }


    public Task Addtask(String title) {
        Task task = new Task();
        task.setCompleted(false);
        task.setTitle(title);
        return taskRepository.save(task);
    }

    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggle(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
        task.setCompleted(!task.getCompleted());
        taskRepository.save(task);
    }
}
