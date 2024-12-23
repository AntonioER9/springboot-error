package com.antonio.course.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.antonio.course.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.antonio.course.springboot.error.springboot_error.models.Error;

@RestController
public class HandlerExceptionController {

  @ExceptionHandler(ArithmeticException.class)
  public ResponseEntity<Error> divisionByZero(Exception e) {
    Error error = new Error();
    error.setMessage(e.getMessage());
    error.setDate(new Date());
    error.setError("Division by zero");
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    // return ResponseEntity.internalServerError().body(error);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
  }

  @ExceptionHandler(NumberFormatException.class)
  public Map<String, Object> numberFormatException(NumberFormatException e) {
    Map<String, Object> error = new HashMap<>();
    error.put("message", e.getMessage());
    error.put("date", new Date());
    error.put("error", "Invalid number format");
    error.put("status", String.valueOf(HttpStatus.BAD_REQUEST.value()));
    return error;
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error> notFoundException(NoHandlerFoundException e) {
    Error error = new Error();
    error.setMessage(e.getMessage());
    error.setError("Resource not found");
    error.setStatus(HttpStatus.NOT_FOUND.value());
    // return ResponseEntity.notFound().body(error);
    return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
  }

  @ExceptionHandler({ NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class })
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String, Object> userNotFoundException(Exception e) {
    Map<String, Object> error = new HashMap<>();
    error.put("message", e.getMessage());
    error.put("date", new Date());
    error.put("error", "Internal server error");
    error.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    return error;
  }

}
