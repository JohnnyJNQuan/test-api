package com.todoservice.gemfirerestapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoservice.gemfirerestapi.model.ToDoItem;
import com.todoservice.gemfirerestapi.model.ToDoItemAddRequest;
import com.todoservice.gemfirerestapi.model.ToDoItemUpdateRequest;
import com.todoservice.gemfirerestapi.repository.TodoRepository;

@Service("toDoService")
public class ToDoServiceImp implements ToDoService{
	
	@Autowired
	private TodoRepository todoRepository;
	// get to-do item by id
	@Override
	public ToDoItem getToDoById(long id) {
		return todoRepository.findById(id);
	}
	// save to-do item
	@Override
	public ToDoItem saveToDo(ToDoItemAddRequest toDoAddRequest) {
		ToDoItem toDoItem = new ToDoItem();
		toDoItem.setText(toDoAddRequest.getText());
		todoRepository.save(toDoItem);
		return toDoItem;
	}
	// update to-do item
	@Override
	public ToDoItem patchToDo(ToDoItemUpdateRequest toDoUpdateRequest, long id) {
		ToDoItem toDoItem = todoRepository.findById(id);
		if (toDoUpdateRequest.getText()!=null) toDoItem.setText(toDoUpdateRequest.getText());
		toDoItem.setIsCompleted(toDoUpdateRequest.isCompleted());
		todoRepository.save(toDoItem);
		return toDoItem;
	}
}
