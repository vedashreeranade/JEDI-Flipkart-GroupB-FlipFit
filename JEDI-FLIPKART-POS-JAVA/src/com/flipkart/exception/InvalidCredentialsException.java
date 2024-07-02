package com.flipkart.exception;

public class InvalidCredentialsException extends Exception{
    @Override
    public String getMessage(){
        return "Wrong credentials. Please enter correct credentials.";
    }
}
