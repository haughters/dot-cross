package org.jhaughton.dotcross.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jhaughton.dotcross.model.TaskEntity;
import org.jhaughton.dotcross.repository.TaskRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.LOCATION;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController()
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public List<TaskEntity> findAll(){
        return repository.findAll();
    }

    @PostMapping(value = "/task", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody TaskEntity task) throws JsonProcessingException {
        repository.save(task);
        HttpHeaders headers = new HttpHeaders();
        headers.add(LOCATION, "task/" + task.getId());
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(task), headers, CREATED);
    }

    @GetMapping(value = "/task/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> retrieve(@PathVariable long id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<TaskEntity> task = repository.findById(id);
        if (task.isPresent()) {
            return new ResponseEntity<>(objectMapper.writeValueAsString(task.get()), OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    @PutMapping(value = "/task/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody TaskEntity task) {
        task.setId(id);
        repository.save(task);
        return new ResponseEntity<>(OK);
    }
}
