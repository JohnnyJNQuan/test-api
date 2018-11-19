package com.todoservice.gemfirerestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
   @ExceptionHandler(value = ItemNotFoundException.class)
   public ResponseEntity<Object> exception(ItemNotFoundException exception, long id) {
      return new ResponseEntity<>("Item not found"+id, HttpStatus.NOT_FOUND);
   }
}