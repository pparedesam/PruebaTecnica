package com.exercise.cuentaservice.account.infraestructure.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
