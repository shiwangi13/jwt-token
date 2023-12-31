package com.springboot.task.services.exception;

import com.springboot.task.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResponseNotFoundException(ResourceNotFoundException ex) {

   String message =     ex.getMessage();
  ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
  return  new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);


    }
}
