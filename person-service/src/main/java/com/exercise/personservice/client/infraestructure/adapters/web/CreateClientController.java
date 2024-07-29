package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.port.CreateClientPort;
import com.exercise.personservice.common.config.EnumMessage;
import com.exercise.personservice.common.handlers.ApiResponseCommon;
import com.exercise.personservice.common.handlers.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class CreateClientController {

    private final CreateClientPort createClientPort;

    @Autowired
    public CreateClientController(CreateClientPort createClientPort) {
        this.createClientPort = createClientPort;
    }

    @PostMapping
    public ResponseEntity<ApiResponseCommon<Void>> createClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        try {
            createClientPort.execute(clientRequestDto);
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    EnumMessage.SUCCESS.getMessage(),
                    null,
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
