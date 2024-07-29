package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.port.DeleteClientPort;
import com.exercise.personservice.common.handlers.ApiResponseCommon;
import com.exercise.personservice.common.handlers.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class DeleteClienteController {

    private final DeleteClientPort deleteClientPort;

    @Autowired
    public DeleteClienteController(DeleteClientPort deleteClientPort) {
        this.deleteClientPort = deleteClientPort;
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseCommon<Void>> deleteClient(@RequestParam("idClient") Long idClient) {
        try {
            deleteClientPort.deleteById(idClient);
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    "Client deleted successfully",
                    null,
                    null
            );
        } catch (Exception e) {
            return ResponseUtil.createExceptionResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error deleting client",
                    List.of("Detail: " + e.getMessage()),
                    e
            );
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseCommon<Void>> handleExceptions(Exception ex) {
        return ResponseUtil.createExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An error occurred",
                List.of("Detail: " + ex.getMessage()),
                ex
        );
    }
}
