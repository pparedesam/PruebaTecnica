package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.port.UpdateClientPort;
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
public class UpdateClientController {

    private final UpdateClientPort updateClientPort;

    @Autowired
    public UpdateClientController(UpdateClientPort updateClientPort) {
        this.updateClientPort = updateClientPort;
    }

    @PutMapping
    public ResponseEntity<ApiResponseCommon<ClientResponseDto>> updateClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        try {
            ClientResponseDto clientResponse = updateClientPort.update(clientRequestDto);
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    EnumMessage.SUCCESS.getMessage(),
                    clientResponse,
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
