package com.exercise.cuentaservice.movement.infraestructure.repository;

import com.exercise.cuentaservice.movement.domain.entities.Movement;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementJpaRepository extends JpaRepository<Movement, Long> {
    void deleteById(@NonNull Long idMovement);
}
