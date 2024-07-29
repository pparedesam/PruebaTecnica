package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.account.domain.entities.Account;
import com.exercise.cuentaservice.account.domain.repository.GetAccountRepository;
import com.exercise.cuentaservice.account.domain.repository.UpdateAccountRepository;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementRequestDto;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.aplication.mapper.MovementMapper;
import com.exercise.cuentaservice.movement.aplication.port.CreateMovementPort;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.CreateMovementRepository;
import com.exercise.cuentaservice.movement.infraestructure.exception.InssuficientBalanceException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateMovementUseCase implements CreateMovementPort {

    private final CreateMovementRepository createMovementRepository;
    private final GetAccountRepository getAccountRepository;
    private final UpdateAccountRepository updateAccountRepository;

    @Autowired
    public CreateMovementUseCase(CreateMovementRepository createMovementRepository, GetAccountRepository getAccountRepository, UpdateAccountRepository updateAccountRepository) {
        this.createMovementRepository = createMovementRepository;
        this.getAccountRepository = getAccountRepository;
        this.updateAccountRepository = updateAccountRepository;
    }

    @Override
    @Transactional
    public MovementResponseDto execute(MovementRequestDto movementRequestDto) {
        Account account = getAccountRepository.findById(movementRequestDto.idAccount());
        BigDecimal newBalance = updateBalance(account.getBalance(), movementRequestDto.value());
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InssuficientBalanceException("Saldo no disponible");
        }
        Movement movement = getMovement(movementRequestDto, account, newBalance);
        Movement movementResponse = createMovementRepository.create(movement);
        updateAccountRepository.update(movement.getAccount());
        return MovementMapper.movementToMovementResponseDto(movementResponse);
    }

    private BigDecimal updateBalance(BigDecimal balance, BigDecimal amount) {
        return balance.add(amount);
    }

    private Movement getMovement(MovementRequestDto movementRequestDto, Account account, BigDecimal newBalance) {
        Movement movement = MovementMapper.movementRequestDtoToMovement(movementRequestDto);
        String typeMovement = movement.getValue().compareTo(BigDecimal.ZERO) < 0 ? "RETIRO" : "DEPOSITO";
        movement.setTypeMovement(typeMovement);
        movement.setBalance(account.getBalance());
        account.setBalance(newBalance);
        movement.setAccount(account);
        return movement;
    }
}
