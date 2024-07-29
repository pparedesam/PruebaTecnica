package com.exercise.cuentaservice.movement.infraestructure.repository;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.domain.repository.GetMovementReportRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MovementReportRepositoryImpl implements GetMovementReportRepository {

    private final MovementReportJpaRepository movementReportJpaRepository;

    public MovementReportRepositoryImpl(MovementReportJpaRepository movementReportJpaRepository) {
        this.movementReportJpaRepository = movementReportJpaRepository;
    }

    @Override
    public List<MovementByClient> findMovementByClients(Date dateIni, Date DateLast, Long idClient) {
        return movementReportJpaRepository.getMovementByClientReport(dateIni, DateLast, idClient);
    }
}
