package com.todoservice.gemfirerestapi.services;

import com.todoservice.gemfirerestapi.model.ToDoItem;
import com.todoservice.gemfirerestapi.model.ToDoItemAddRequest;
import com.todoservice.gemfirerestapi.model.ToDoItemUpdateRequest;

public interface ToDoService {
	public ToDoItem getToDoById(long id);
	public ToDoItem saveToDo(ToDoItemAddRequest toDoAddRequest);
	public ToDoItem patchToDo(ToDoItemUpdateRequest toDoUpdateRequest, long id);
}
