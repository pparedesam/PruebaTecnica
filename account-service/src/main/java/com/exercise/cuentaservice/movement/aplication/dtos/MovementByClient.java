package com.exercise.cuentaservice.movement.aplication.dtos;

import java.math.BigDecimal;
import java.util.Date;

public interface MovementByClient {

    Date getDate();
    String getName();
    String getNumber();
    String getType();
    BigDecimal getBalance();
    Boolean getState();
    BigDecimal getValue();
    BigDecimal getAvailable();
}
