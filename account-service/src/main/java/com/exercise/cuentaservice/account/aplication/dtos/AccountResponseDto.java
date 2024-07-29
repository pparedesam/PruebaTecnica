package com.exercise.cuentaservice.account.aplication.dtos;

import java.math.BigDecimal;

public record AccountResponseDto(

        Long idAccount,
        String accountType,
        BigDecimal initialBalance,
        Boolean status,
        String nameClient,
        String accountNumber
) {


}
