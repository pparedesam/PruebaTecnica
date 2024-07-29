package com.exercise.personservice.client.infraestructure.exception;

public class ClientNotFoundException  extends RuntimeException {
    public ClientNotFoundException (String message) {
        super(message);
    }
}