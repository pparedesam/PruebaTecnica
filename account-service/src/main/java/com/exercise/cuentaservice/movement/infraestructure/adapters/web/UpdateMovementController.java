package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.common.config.EnumMessage;
import com.exercise.cuentaservice.common.handlers.ApiResponseCommon;
import com.exercise.cuentaservice.common.handlers.ResponseUtil;
import com.exercise.cuentaservice.movement.aplication.port.UpdateMovementPort;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movement")
public class UpdateMovementController {

    private final UpdateMovementPort updateMovementPort;

    @Autowired
    public UpdateMovementController(UpdateMovementPort updateMovementPort) {
        this.updateMovementPort = updateMovementPort;
    }

    @PutMapping
    public ResponseEntity<ApiResponseCommon<Movement>> updateMovement(@Valid @RequestBody Movement movement) {
        try {
            Movement movementResponse = updateMovementPort.update(movement);
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    EnumMessage.SUCCESS.getMessage(),
                    movementResponse,
                    null
            );
        } catch (Exception e) {
            return ResponseUtil.createExceptionResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    EnumMessage.ERROR_PROCESSING.getMessage(),
                    List.of("Detail: " + e.getMessage()),
                    e
            );
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseCommon<Void>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(this::formatFieldError)
                .toList();

        return ResponseUtil.createErrorResponse(
                HttpStatus.BAD_REQUEST,
                EnumMessage.VALIDATION_ERROR.getMessage(),
                errors
        );
    }

    private String formatFieldError(FieldError error) {
        return String.format("%s: %s", error.getField(), error.getDefaultMessage());
    }
}
