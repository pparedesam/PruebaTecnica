package com.exercise.cuentaservice.movement.aplication.port;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementRequestDto;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;

public interface CreateMovementPort {
    MovementResponseDto execute(MovementRequestDto movement);
}
