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
	
	@Override
	public ToDoItem getToDoById(long id) {
		return todoRepository.findById(id);
	}

	@Override
	public ToDoItem saveToDo(ToDoItemAddRequest toDoAddRequest) {
		ToDoItem toDoItem = new ToDoItem();
		toDoItem.setText(toDoAddRequest.getText());
		todoRepository.save(toDoItem);
		return toDoItem;
	}
	
	@Override
	public ToDoItem patchToDo(ToDoItemUpdateRequest toDoUpdateRequest, long id) {
		ToDoItem toDoItem = todoRepository.findById(id);
		if (toDoUpdateRequest.getText()!=null) toDoItem.setText(toDoUpdateRequest.getText());
		toDoItem.setIsCompleted(toDoUpdateRequest.isCompleted());
		todoRepository.save(toDoItem);
		return toDoItem;
	}
}
