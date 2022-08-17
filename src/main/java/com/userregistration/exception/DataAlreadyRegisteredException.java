package com.userregistration.exception;

public class DataAlreadyRegisteredException extends RuntimeException {

    public DataAlreadyRegisteredException(String message) {
        super(message);
    }

}
