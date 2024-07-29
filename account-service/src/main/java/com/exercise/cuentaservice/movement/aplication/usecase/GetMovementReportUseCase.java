package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementReportPort;
import com.exercise.cuentaservice.movement.domain.repository.GetMovementReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GetMovementReportUseCase implements GetMovementReportPort {

    private final GetMovementReportRepository getMovementReportRepository;

    @Autowired
    public GetMovementReportUseCase(GetMovementReportRepository getMovementReportRepository) {
        this.getMovementReportRepository = getMovementReportRepository;
    }

    @Override
    public List<MovementByClient> execute(Date dateIni, Date dateLast, Long idClient) {
        return getMovementReportRepository.findMovementByClients(dateIni, dateLast, idClient);
    }
}
