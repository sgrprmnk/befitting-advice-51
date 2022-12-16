package com.example.exceptions;

public class LoginException extends Exception{
    public LoginException(){

    }

    public LoginException(String message) {
        super(message);
    }
}
