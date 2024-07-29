package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.port.GetClientByNamePort;
import com.exercise.personservice.client.application.port.GetClientPort;
import com.exercise.personservice.client.application.port.GetClientsPort;
import com.exercise.personservice.common.config.EnumMessage;
import com.exercise.personservice.common.handlers.ApiResponseCommon;
import com.exercise.personservice.common.handlers.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class GetClientController {

    private final GetClientsPort getClientsPort;
    private final GetClientPort getClientPort;
    private final GetClientByNamePort getClientByNamePort;

    @Autowired
    public GetClientController(GetClientsPort getClientsPort, GetClientPort getClientPort, GetClientByNamePort getClientByNamePort) {
        this.getClientsPort = getClientsPort;
        this.getClientPort = getClientPort;
        this.getClientByNamePort = getClientByNamePort;
    }

    @GetMapping
    public ResponseEntity<ApiResponseCommon<List<ClientResponseDto>>> getClients() {
        try {
            List<ClientResponseDto> clients = getClientsPort.execute();
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    EnumMessage.SUCCESS.getMessage(),
                    clients,
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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseCommon<ClientResponseDto>> getClientById(@PathVariable("id") Long id) {
        try {
            ClientResponseDto client = getClientPort.findById(id);
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    EnumMessage.SUCCESS.getMessage(),
                    client,
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

    @GetMapping("/name")
    public ResponseEntity<ApiResponseCommon<List<ClientResponseDto>>> getClientByName(@RequestParam("name") String name) {
        try {
            List<ClientResponseDto> clients = getClientByNamePort.findByName(name);
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    EnumMessage.SUCCESS.getMessage(),
                    clients,
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
}
