package org.jhaughton.dotcross.repository;

import org.jhaughton.dotcross.model.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findByName(String name);
    List<TaskEntity> findAll();
}
