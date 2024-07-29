package com.exercise.cuentaservice.movement.aplication.dtos;

import java.math.BigDecimal;
import java.util.Date;

public record MovementReportDto(
        Date date,
        String name,
        Long accountNumber,
        String accountType,
        BigDecimal initialBalance,
        String typeMovement,
        Boolean state,
        BigDecimal movement
        ) {
}
