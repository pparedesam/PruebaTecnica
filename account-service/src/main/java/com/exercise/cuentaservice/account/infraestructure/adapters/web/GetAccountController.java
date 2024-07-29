package com.exercise.cuentaservice.account.infraestructure.adapters.web;

import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.aplication.port.GetAccountPort;
import com.exercise.cuentaservice.common.config.EnumMessage;
import com.exercise.cuentaservice.common.handlers.ApiResponseCommon;
import com.exercise.cuentaservice.common.handlers.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class GetAccountController {

    private final GetAccountPort getAccountPort;

    @Autowired
    public GetAccountController(GetAccountPort getAccountPort) {
        this.getAccountPort = getAccountPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponseCommon<List<AccountResponseDto>>> getAccount() {
        try {
            List<AccountResponseDto> accounts = getAccountPort.execute();
            return ResponseUtil.createSuccessResponse(HttpStatus.OK, "Accounts retrieved successfully", accounts, null);
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
