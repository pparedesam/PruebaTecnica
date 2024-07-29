package com.exercise.cuentaservice.movement.infraestructure.repository;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovementReportJpaRepository extends JpaRepository<Movement, Long> {

    @Query(value = "SELECT m.date, p.name, a.number, a.type, m.balance, a.state, m.value, " +
            "m.balance + m.value AS Available " +
            "FROM account a " +
            "JOIN movement m ON m.id_account = a.id " +
            "JOIN client c ON c.id = a.id_client " +
            "JOIN person p ON p.id = c.person_id " +
            "WHERE a.id = :idClient AND m.date BETWEEN :dateIni AND :dateLast",
            nativeQuery = true)
    List<MovementByClient> getMovementByClientReport(Date dateIni, Date dateLast, Long idClient);
}
