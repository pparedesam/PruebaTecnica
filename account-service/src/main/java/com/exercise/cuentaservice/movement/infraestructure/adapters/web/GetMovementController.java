package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.common.config.EnumMessage;
import com.exercise.cuentaservice.common.handlers.ApiResponseCommon;
import com.exercise.cuentaservice.common.handlers.ResponseUtil;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/movement")
public class GetMovementController {

    private final GetMovementPort getMovementPort;

    @Autowired
    public GetMovementController(GetMovementPort getMovementPort) {
        this.getMovementPort = getMovementPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponseCommon<List<MovementResponseDto>>> getMovement() {
        try {
            List<MovementResponseDto> movements = getMovementPort.execute();
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    EnumMessage.SUCCESS.getMessage(),
                    movements,
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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseCommon<Void>> handleExceptions(Exception ex) {
        return ResponseUtil.createExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                EnumMessage.VALIDATION_ERROR.getMessage(),
                List.of("Detail: " + ex.getMessage()),
                ex
        );
    }
}
