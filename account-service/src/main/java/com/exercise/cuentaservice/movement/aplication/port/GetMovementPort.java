package com.exercise.cuentaservice.movement.aplication.port;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;

import java.util.List;

public interface GetMovementPort {
    List<MovementResponseDto> execute();
}
