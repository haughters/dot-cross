package org.jhaughton.dotcross;

import org.jhaughton.dotcross.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DotCrossApplication {

    @Autowired
    TaskRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(DotCrossApplication.class, args);
    }

}
