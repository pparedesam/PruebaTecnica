package com.exercise.cuentaservice.movement.infraestructure.exception;

public class InssuficientBalanceException extends RuntimeException{
    public InssuficientBalanceException(String message){
        super(message);
    }
}
