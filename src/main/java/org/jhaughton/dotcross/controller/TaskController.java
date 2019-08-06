package org.jhaughton.dotcross.controller;

import org.jhaughton.dotcross.model.Task;
import org.jhaughton.dotcross.model.TaskEntity;
import org.jhaughton.dotcross.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public String create(@RequestBody Task task) {
        repository.save(new TaskEntity(task.getName(), task.getDescription(), task.getDateCompleted()));
        return "Customer is created";
    }

    @GetMapping("/findall")
    public List<Task> findAll(){
        List<TaskEntity> taskEntities = repository.findAll();
        List<Task> tasks = new ArrayList<>();
        for (TaskEntity taskEntity : taskEntities) {
            tasks.add(new Task(taskEntity.getId(), taskEntity.getName(), taskEntity.getDescription(), taskEntity.getDateCompleted()));
        }
        return tasks;
    }

    @RequestMapping("/search/{id}")
    public String search(@PathVariable long id){
        String task = "";
        task = repository.findById(id).toString();
        return task;
    }

    @RequestMapping("/searchbyname/{name}")
    public List<Task> fetchDataByFirstName(@PathVariable String name){
        List<TaskEntity> taskEntities = repository.findByName(name);
        List<Task> tasks = new ArrayList<>();
        for (TaskEntity taskEntity : taskEntities) {
            tasks.add(new Task(taskEntity.getId(), taskEntity.getName(), taskEntity.getDescription(), taskEntity.getDateCompleted()));
        }
        return tasks;
    }
}
