package com.exercise.cuentaservice.account.aplication.usecase;

import com.exercise.cuentaservice.account.aplication.dtos.AccountRequestDto;
import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.aplication.dtos.ClientResponseDto;
import com.exercise.cuentaservice.account.aplication.mapper.AccountMapper;
import com.exercise.cuentaservice.account.aplication.port.UpdateAccountPort;
import com.exercise.cuentaservice.account.domain.entities.Account;
import com.exercise.cuentaservice.account.domain.repository.UpdateAccountRepository;
import com.exercise.cuentaservice.account.infraestructure.client.PersonServiceClient;
import com.exercise.cuentaservice.account.infraestructure.exception.ClientNotFoundException;
import com.exercise.cuentaservice.common.config.EnumMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase implements UpdateAccountPort {

    private final UpdateAccountRepository updateAccountRepository;
    private final PersonServiceClient personServiceClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public UpdateAccountUseCase(UpdateAccountRepository updateAccountRepository, PersonServiceClient personServiceClient) {
        this.updateAccountRepository = updateAccountRepository;
        this.personServiceClient = personServiceClient;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public AccountResponseDto update(AccountRequestDto accountRequestDto) {

        Account account = AccountMapper.accountDtoToAccount(accountRequestDto);
        ClientResponseDto clientResponseDto = findClientById(accountRequestDto.idClient());
        String numCuenta = updateAccountRepository.findNumberById(accountRequestDto.id());
        account.setNumber(numCuenta);
        Account updatedAccount = updateAccountRepository.update(account);

        return AccountMapper.accountToAccountDto(updatedAccount, clientResponseDto.name());
    }

    private ClientResponseDto findClientById(Long id) {
        try {
            String response = personServiceClient.getClient(id);
            return objectMapper.readValue(response, ClientResponseDto.class);
        } catch (JsonProcessingException e) {
            throw new ClientNotFoundException(EnumMessage.ERROR_PROCESSING.getMessage(), e);
        }
    }
}
