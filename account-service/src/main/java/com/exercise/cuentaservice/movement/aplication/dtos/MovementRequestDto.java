package com.exercise.cuentaservice.movement.aplication.dtos;

import java.math.BigDecimal;
import java.util.Date;

public record MovementRequestDto(
        Date date,
        Long idAccount,
        BigDecimal value
        ) {




}
