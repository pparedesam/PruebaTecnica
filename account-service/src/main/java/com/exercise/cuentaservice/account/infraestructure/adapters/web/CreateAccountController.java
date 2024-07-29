package com.exercise.cuentaservice.account.infraestructure.adapters.web;

import com.exercise.cuentaservice.account.aplication.dtos.AccountRequestDto;
import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.aplication.port.CreateAccountPort;
import com.exercise.cuentaservice.common.config.EnumMessage;
import com.exercise.cuentaservice.common.handlers.ApiResponseCommon;
import com.exercise.cuentaservice.common.handlers.ResponseUtil;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class CreateAccountController {

    private final CreateAccountPort createAccountPort;

    public CreateAccountController(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiResponseCommon<AccountResponseDto>> createAccount(@RequestBody AccountRequestDto accountRequestDto) {
        try {
            AccountResponseDto accountResponseDto = createAccountPort.execute(accountRequestDto);
            return createSuccessResponse(HttpStatus.OK, EnumMessage.SUCCESS.getMessage(), accountResponseDto);
        } catch (ConstraintViolationException e) {
            return handleValidationException(e);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    private ResponseEntity<ApiResponseCommon<AccountResponseDto>> createSuccessResponse(HttpStatus status, String message, AccountResponseDto data) {
        return ResponseUtil.createSuccessResponse(status, message, data, null);
    }

    private ResponseEntity<ApiResponseCommon<AccountResponseDto>> handleValidationException(ConstraintViolationException e) {
        List<String> validationErrors = e.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .toList();
        return ResponseUtil.createErrorResponse(HttpStatus.BAD_REQUEST, EnumMessage.VALIDATION_ERROR.getMessage(), validationErrors);
    }

    private ResponseEntity<ApiResponseCommon<AccountResponseDto>> handleException(Exception e) {
        return ResponseUtil.createExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                EnumMessage.ERROR_PROCESSING.getMessage(),
                List.of("Detalle del error: " + e.getMessage()),
                e
        );
    }
}
