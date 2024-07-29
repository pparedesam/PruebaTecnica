package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.aplication.mapper.MovementMapper;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementPort;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.GetMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetMovementUseCase implements GetMovementPort {

    private final GetMovementRepository getMovementRepository;

    @Autowired
    public GetMovementUseCase(GetMovementRepository getMovementRepository) {
        this.getMovementRepository = getMovementRepository;
    }

    @Override
    public List<MovementResponseDto> execute() {
        List<Movement> movements = getMovementRepository.findAll();
        return movements.stream()
                .map(MovementMapper::movementToMovementResponseDto)
                .collect(Collectors.toList());
    }
}
