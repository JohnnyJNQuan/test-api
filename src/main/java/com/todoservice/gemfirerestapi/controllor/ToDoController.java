package com.todoservice.gemfirerestapi.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.todoservice.gemfirerestapi.model.ToDoItem;
import com.todoservice.gemfirerestapi.model.ToDoItemAddRequest;
import com.todoservice.gemfirerestapi.model.ToDoItemUpdateRequest;
import com.todoservice.gemfirerestapi.services.ToDoService;
import com.todoservice.gemfirerestapi.exception.ItemNotFoundException;
import com.todoservice.gemfirerestapi.exception.NullInputException;
import com.todoservice.gemfirerestapi.exception.ValidationErrorException;;

@RestController
public class ToDoController {
	@Autowired
	private ToDoService toDoService;
	
	// get to-do item by id
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public ResponseEntity<ToDoItem>  getItem(@PathVariable("id") long id) throws Exception {
		ToDoItem toDoItem = toDoService.getToDoById(id);
		if(toDoItem==null) throw new ItemNotFoundException("Item with "+id+" not found");
    	 return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
    }
	// create a to-do item
	@PostMapping("/todo")
    public ResponseEntity<ToDoItem> postItem( @RequestBody ToDoItemAddRequest toDoItemAddRequest) throws Exception {
		if (toDoItemAddRequest.getText()==null) throw new NullInputException();
		if (toDoItemAddRequest.getText().length()>50 ||toDoItemAddRequest.getText().length()<1 ) 
			throw new ValidationErrorException(toDoItemAddRequest.getText());
		ToDoItem toDoItem = toDoService.saveToDo(toDoItemAddRequest);
    	 return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
    }
	// update a to-do item
	@PatchMapping("/todo/{id}")
    public ResponseEntity<ToDoItem> patchItem(@RequestBody ToDoItemUpdateRequest toDoItemUpdateRequest, @PathVariable("id") long id ) throws Exception {
		if (toDoItemUpdateRequest.getText()!=null && (toDoItemUpdateRequest.getText().length()>50 ||toDoItemUpdateRequest.getText().length()<1 )) 
			throw new ValidationErrorException(toDoItemUpdateRequest.getText());
		ToDoItem toDoItem = toDoService.patchToDo(toDoItemUpdateRequest,id);
    
    	 return new ResponseEntity<ToDoItem>(toDoItem, HttpStatus.OK);
    }


}