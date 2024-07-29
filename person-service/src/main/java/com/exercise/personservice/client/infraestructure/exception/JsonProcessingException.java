package com.exercise.personservice.client.infraestructure.exception;

public class JsonProcessingException extends RuntimeException {


    public JsonProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
