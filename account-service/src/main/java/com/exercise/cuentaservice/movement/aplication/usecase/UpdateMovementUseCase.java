package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.movement.aplication.port.UpdateMovementPort;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.UpdateMovementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateMovementUseCase implements UpdateMovementPort {

    private final UpdateMovementRepository updateMovementRepository;

    @Autowired
    public UpdateMovementUseCase(UpdateMovementRepository updateMovementRepository) {
        this.updateMovementRepository = updateMovementRepository;
    }

    @Override
    @Transactional
    public Movement update(Movement movement) {
        return updateMovementRepository.update(movement);
    }
}
