package com.exercise.cuentaservice.account.aplication.dtos;



import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AccountRequestDto(

        Long id,

        @NotBlank(message = "Account type is mandatory")
        String accountType,

        @NotNull(message = "Initial balance is mandatory")
        @DecimalMin(value = "0.0", inclusive = false, message = "Initial balance must be positive")
        BigDecimal initialBalance,

        @NotNull(message = "Status is mandatory")
        Boolean status,

        @NotNull(message = "Client ID is mandatory")
        Long idClient
) {
}
