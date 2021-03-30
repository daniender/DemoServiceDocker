package com.daniender.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.daniender.demo.model.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
