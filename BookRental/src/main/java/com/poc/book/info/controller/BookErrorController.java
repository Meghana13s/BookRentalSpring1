package com.poc.book.info.controller;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.poc.book.info.exception.BookNotFoundException;
import com.poc.book.info.exception.ErrorResponse;
import com.poc.book.info.exception.NoDataFoundException;

import jakarta.servlet.http.HttpServletRequest;
@RestControllerAdvice
public class BookErrorController { //returns error response
    
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(value= BookNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleBookNotFoundException(Exception ex, HttpServletRequest request) {
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        LocalDateTime timestamp = LocalDateTime.now();
        int status = HttpStatus.NOT_FOUND.value();
        String error = HttpStatus.NOT_FOUND.getReasonPhrase();
        String message = ex.getMessage();
        String path = request.getRequestURI();
        
        ErrorResponse body=new ErrorResponse(timestamp, status, error, message, path);
        return ResponseEntity.status(httpStatus).body(body);
        }
    
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(value= NoDataFoundException.class)
    public ResponseEntity<ErrorResponse>handleNoDataFoundException(Exception ex, HttpServletRequest request) {
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        LocalDateTime timestamp = LocalDateTime.now();
        int status = HttpStatus.NOT_FOUND.value();
        String error = HttpStatus.NOT_FOUND.getReasonPhrase();
        String message = ex.getMessage();
        String path = request.getRequestURI();
        
        ErrorResponse body=new ErrorResponse(timestamp, status, error, message, path);
        return ResponseEntity.status(httpStatus).body(body);
        }



}