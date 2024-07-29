package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.common.config.EnumMessage;
import com.exercise.cuentaservice.common.handlers.ApiResponseCommon;
import com.exercise.cuentaservice.common.handlers.ResponseUtil;
import com.exercise.cuentaservice.movement.aplication.port.DeleteMovementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movement")
public class DeleteMovementController {

    private final DeleteMovementPort deleteMovementPort;

    @Autowired
    public DeleteMovementController(DeleteMovementPort deleteMovementPort) {
        this.deleteMovementPort = deleteMovementPort;
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseCommon<Void>> deleteMovement(@RequestParam("idMovement") Long idMovement) {
        try {
            deleteMovementPort.deleteById(idMovement);
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
