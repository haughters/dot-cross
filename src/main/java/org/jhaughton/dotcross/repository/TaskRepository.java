package org.jhaughton.dotcross.repository;

import org.jhaughton.dotcross.model.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findByName(String name);
    List<TaskEntity> findAll();
}
