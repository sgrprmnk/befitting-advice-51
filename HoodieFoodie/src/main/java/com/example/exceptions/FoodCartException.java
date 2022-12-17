package com.example.exceptions;

public class FoodCartException extends Exception{
    public FoodCartException() {
    }

    public FoodCartException(String message) {
        super(message);
    }
}
