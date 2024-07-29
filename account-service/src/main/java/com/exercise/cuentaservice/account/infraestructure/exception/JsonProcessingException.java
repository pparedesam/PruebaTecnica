package com.exercise.cuentaservice.account.infraestructure.exception;

public class JsonProcessingException extends RuntimeException {


    public JsonProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
