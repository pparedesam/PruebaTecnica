package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.movement.aplication.port.DeleteMovementPort;
import com.exercise.cuentaservice.movement.domain.repository.DeleteMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMovementUseCase implements DeleteMovementPort {

    private final DeleteMovementRepository deleteMovementRepository;

    @Autowired
    public DeleteMovementUseCase(DeleteMovementRepository deleteMovementRepository) {
        this.deleteMovementRepository = deleteMovementRepository;
    }

    @Override
    public void deleteById(Long idMovement) {
        deleteMovementRepository.deleteById(idMovement);
    }
}
