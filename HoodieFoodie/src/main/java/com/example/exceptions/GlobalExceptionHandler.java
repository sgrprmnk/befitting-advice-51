package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(CustomerException ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        ResponseEntity<MyErrorDetails> re=new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        return re;
    }

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(AdminException ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        ResponseEntity<MyErrorDetails> re=new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        return re;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(Exception ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        ResponseEntity<MyErrorDetails> re=new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
        return re;
    }
    //to handle Not found exception
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
}
