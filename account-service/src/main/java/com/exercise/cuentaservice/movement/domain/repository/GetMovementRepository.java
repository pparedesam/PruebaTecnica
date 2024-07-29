package com.exercise.cuentaservice.movement.domain.repository;

import com.exercise.cuentaservice.movement.domain.entities.Movement;

import java.util.List;

public interface GetMovementRepository {

    List<Movement> findAll();
}
