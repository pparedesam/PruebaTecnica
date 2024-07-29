package com.exercise.cuentaservice.movement.aplication.port;

import com.exercise.cuentaservice.movement.domain.entities.Movement;

public interface UpdateMovementPort {
    Movement update(Movement movement);
}
