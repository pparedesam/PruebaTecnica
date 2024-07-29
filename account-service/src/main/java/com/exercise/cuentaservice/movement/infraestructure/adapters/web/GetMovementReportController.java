package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.common.config.EnumMessage;
import com.exercise.cuentaservice.common.handlers.ApiResponseCommon;
import com.exercise.cuentaservice.common.handlers.ResponseUtil;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementReportPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/reports")
public class GetMovementReportController {

    private final GetMovementReportPort getMovementReportPort;

    @Autowired
    public GetMovementReportController(GetMovementReportPort getMovementReportPort) {
        this.getMovementReportPort = getMovementReportPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponseCommon<List<MovementByClient>>> getMovementByClient(
            @RequestParam("dateIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateIni,
            @RequestParam("dateLast") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateLast,
            @RequestParam("idClient") Long idClient) {
        try {
            List<MovementByClient> movements = getMovementReportPort.execute(dateIni, dateLast, idClient);
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
