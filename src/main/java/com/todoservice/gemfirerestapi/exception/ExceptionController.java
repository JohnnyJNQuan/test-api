package com.todoservice.gemfirerestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.todoservice.gemfirerestapi.model.ToDoItemNotFoundError;
import com.todoservice.gemfirerestapi.model.ToDoItemNotFoundErrorDetails;
import com.todoservice.gemfirerestapi.model.ToDoItemValidationError;
import com.todoservice.gemfirerestapi.model.ToDoItemValidationErrorDetails;

@ControllerAdvice
public class ExceptionController {
   @ExceptionHandler(value = ItemNotFoundException.class)
   public ResponseEntity<Object> notFoundException(ItemNotFoundException exception) {
	   ToDoItemNotFoundErrorDetails[] toDoItemNotFoundErrorDetailsArray = 
			   new ToDoItemNotFoundErrorDetails[1];
	   ToDoItemNotFoundErrorDetails toDoItemNotFoundErrorDetails = 
			   new ToDoItemNotFoundErrorDetails();
	   ToDoItemNotFoundError toDoItemNotFoundError = new ToDoItemNotFoundError();
	   toDoItemNotFoundErrorDetails.setMessage(exception.getMessage());
	   toDoItemNotFoundErrorDetailsArray[0]=toDoItemNotFoundErrorDetails;
	   toDoItemNotFoundError.setDetails(toDoItemNotFoundErrorDetailsArray);
	   toDoItemNotFoundError.setName("NotFoundError");
      return new ResponseEntity<>(toDoItemNotFoundError, HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(value = ValidationErrorException.class)
   public ResponseEntity<Object> validatErrorException(ValidationErrorException exception) {
	   ToDoItemValidationErrorDetails[] toDoItemValidationErrorDetailssArray = 
			   new ToDoItemValidationErrorDetails[1];
	   ToDoItemValidationErrorDetails toDoItemValidationErrorDetails = 
			   new ToDoItemValidationErrorDetails();
	   ToDoItemValidationError toDoItemValidationError = new ToDoItemValidationError();
	   toDoItemValidationErrorDetails.setMsg("Must be between 1 and 50 chars long");
	   toDoItemValidationErrorDetails.setLocation("params");
	   toDoItemValidationErrorDetails.setParam("text");
	   toDoItemValidationErrorDetails.setValue(exception.getMessage());
	   toDoItemValidationErrorDetailssArray[0]=toDoItemValidationErrorDetails;
	   toDoItemValidationError.setDetails(toDoItemValidationErrorDetailssArray);
	   toDoItemValidationError.setName("ValidationError");
      return new ResponseEntity<>(toDoItemValidationError, HttpStatus.BAD_REQUEST);
   }
   
   @ExceptionHandler(value = BalancedInputValidationErrorException.class)
   public ResponseEntity<Object> balancedInputValidationErrorException(BalancedInputValidationErrorException exception) {
	   ToDoItemValidationErrorDetails[] validationErrorDetailssArray = 
			   new ToDoItemValidationErrorDetails[1];
	   ToDoItemValidationErrorDetails validationErrorDetails = 
			   new ToDoItemValidationErrorDetails();
	   ToDoItemValidationError validationError = new ToDoItemValidationError();
	   validationErrorDetails.setMsg("Invalid value");
	   validationErrorDetails.setLocation("query");
	   validationErrorDetails.setParam("input");
	   validationErrorDetails.setValue(exception.getMessage());
	   validationErrorDetailssArray[0]=validationErrorDetails;
	   validationError.setDetails(validationErrorDetailssArray);
	   validationError.setName("ValidationError");
      return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
   }
   
   @ExceptionHandler(value = NullInputException.class)
   public ResponseEntity<Object> nullInputException(NullInputException exception) {
	   ToDoItemValidationErrorDetails[] validationErrorDetailssArray = 
			   new ToDoItemValidationErrorDetails[1];
	   ToDoItemValidationErrorDetails validationErrorDetails = 
			   new ToDoItemValidationErrorDetails();
	   ToDoItemValidationError validationError = new ToDoItemValidationError();
	   validationErrorDetails.setMsg("Text field must be defined");
	   validationErrorDetails.setLocation("params");
	   validationErrorDetails.setParam("text");
	   validationErrorDetailssArray[0]=validationErrorDetails;
	   validationError.setDetails(validationErrorDetailssArray);
	   validationError.setName("ValidationError");
      return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
   }
}