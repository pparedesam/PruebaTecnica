package com.exercise.cuentaservice.movement.domain.repository;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;

import java.util.Date;
import java.util.List;

public interface GetMovementReportRepository {

    List<MovementByClient> findMovementByClients(Date dateIni, Date dateLast, Long idClient);
}
