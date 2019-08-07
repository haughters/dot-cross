package org.jhaughton.dotcross.controller;

import org.jhaughton.dotcross.model.TaskEntity;
import org.jhaughton.dotcross.repository.TaskRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController()
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/task/create")
    public ResponseEntity<String> create(@RequestBody TaskEntity task) {
        repository.save(task);
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        return new ResponseEntity<>("{\"id\":\"" + task.getId() + "\"}", headers, CREATED);
    }

    @GetMapping("/tasks")
    public List<TaskEntity> findAll(){
        return repository.findAll();
    }

    @RequestMapping("/task/{id}")
    public String search(@PathVariable long id){
        String task = "";
        task = repository.findById(id).toString();
        return task;
    }
}
