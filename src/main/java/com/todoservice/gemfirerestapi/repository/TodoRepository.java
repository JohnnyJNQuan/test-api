package com.todoservice.gemfirerestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.todoservice.gemfirerestapi.model.ToDoItem;

@RepositoryRestResource(collectionResourceRel = "todoitem", path = "todoitem")
public interface TodoRepository  extends CrudRepository<ToDoItem, Long> {
	ToDoItem findById(@Param("id") long id);
}