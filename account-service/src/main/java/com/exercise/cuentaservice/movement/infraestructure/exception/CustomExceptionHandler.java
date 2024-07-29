package com.exercise.cuentaservice.movement.infraestructure.exception;

import com.exercise.cuentaservice.movement.infraestructure.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InssuficientBalanceException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationException(InssuficientBalanceException ex) {
        ErrorResponseDto error = new ErrorResponseDto(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
