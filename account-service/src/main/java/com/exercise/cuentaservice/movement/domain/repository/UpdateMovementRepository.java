package com.exercise.cuentaservice.movement.domain.repository;

import com.exercise.cuentaservice.movement.domain.entities.Movement;

public interface UpdateMovementRepository {

    Movement update(Movement movement);
}
