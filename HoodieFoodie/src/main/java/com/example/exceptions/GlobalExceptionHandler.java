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
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(AdminException ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails> ItemExceptionHandler(ItemException ce, WebRequest req){
    	
    	  MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
	}
    
    @ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails> RestaurantExceptionHandler(RestaurantException ce, WebRequest req){
		
    	 MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
 		
 		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
 		

		
	}
    
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> CartExceptionHandler(CartException ce, WebRequest req){
		
		 MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
			
	}



    @ExceptionHandler(OrderDetailsException.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(OrderDetailsException ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BillException.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(BillException ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FoodCartException.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(FoodCartException ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(LoginException ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    //Others Exception Handle
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> myIllegalHandler(Exception ie, WebRequest req){
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ie.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    //to handle Not found exception
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
        MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }


}
