package com.kurocho.geogames.utils.exception;

public class InvalidEmailException extends Exception {

    public InvalidEmailException(){
        super();
    }

    public InvalidEmailException(String message){
        super(message);
    }
}
