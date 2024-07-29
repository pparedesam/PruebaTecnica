package com.exercise.cuentaservice.movement.aplication.dtos;

import java.math.BigDecimal;

public record MovementResponseDto(
        String numero,
        String accountType,
        BigDecimal initialBalance,
        Boolean state,
        String movement
) {
}
