package com.exercise.cuentaservice.account.infraestructure.adapters.web;

import com.exercise.cuentaservice.account.aplication.port.DeleteAccountPort;
import com.exercise.cuentaservice.account.infraestructure.exception.AccountNotFoundException;
import com.exercise.cuentaservice.common.handlers.ApiResponseCommon;
import com.exercise.cuentaservice.common.handlers.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/v1/account")
public class DeleteClientController {

    private final DeleteAccountPort deleteAccountPort;

    public DeleteClientController(DeleteAccountPort deleteAccountPort) {
        this.deleteAccountPort = deleteAccountPort;
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseCommon<Void>> deleteAccount(@RequestParam("idAccount") Long idAccount) {
        try {
            deleteAccountPort.deleteById(idAccount);
            return ResponseUtil.createSuccessResponse(
                    HttpStatus.OK,
                    "Account deleted successfully",
                    null,
                    null
            );
        } catch (AccountNotFoundException e) {
            return ResponseUtil.createErrorResponse(
                    HttpStatus.NOT_FOUND,
                    "Account not found",
                    Collections.singletonList(e.getMessage())
            );
        } catch (Exception e) {
            return ResponseUtil.createExceptionResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "An unexpected error occurred",
                    Collections.singletonList("Detail: " + e.getMessage()),
                    e
            );
        }
    }
}
