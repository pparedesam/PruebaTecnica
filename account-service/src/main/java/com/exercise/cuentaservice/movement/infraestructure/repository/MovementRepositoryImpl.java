package com.exercise.cuentaservice.movement.infraestructure.repository;

import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.CreateMovementRepository;
import com.exercise.cuentaservice.movement.domain.repository.DeleteMovementRepository;
import com.exercise.cuentaservice.movement.domain.repository.GetMovementRepository;
import com.exercise.cuentaservice.movement.domain.repository.UpdateMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovementRepositoryImpl implements GetMovementRepository, CreateMovementRepository, UpdateMovementRepository, DeleteMovementRepository {

    private final MovementJpaRepository movementJpaRepository;

    @Autowired
    public MovementRepositoryImpl(MovementJpaRepository movementJpaRepository) {
        this.movementJpaRepository = movementJpaRepository;
    }

    @Override
    public void deleteById(Long idMovement) {
        movementJpaRepository.deleteById(idMovement);
    }

    @Override
    public List<Movement> findAll() {
        return movementJpaRepository.findAll();
    }

    @Override
    public Movement update(Movement movement) {
        return movementJpaRepository.save(movement);
    }

    @Override
    public Movement create(Movement movement) {
        return movementJpaRepository.save(movement);
    }
}
