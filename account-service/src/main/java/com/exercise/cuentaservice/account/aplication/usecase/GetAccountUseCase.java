package com.exercise.cuentaservice.account.aplication.usecase;

import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.aplication.dtos.ClientResponseDto;
import com.exercise.cuentaservice.account.aplication.port.GetAccountPort;
import com.exercise.cuentaservice.account.domain.repository.GetAccountRepository;
import com.exercise.cuentaservice.account.infraestructure.client.PersonServiceClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetAccountUseCase implements GetAccountPort {

    private final GetAccountRepository getAccountRepository;
    private final PersonServiceClient personServiceClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public GetAccountUseCase(GetAccountRepository getAccountRepository, PersonServiceClient personServiceClient, ObjectMapper objectMapper) {
        this.getAccountRepository = getAccountRepository;
        this.personServiceClient = personServiceClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<AccountResponseDto> execute() {
        return getAccountRepository.findAll().stream()
                .map(account -> {
                    String response = personServiceClient.getClient(account.getIdClient());
                    ClientResponseDto clientResponseDto = parseClientResponse(response);
                    return new AccountResponseDto(
                            account.getId(),
                            account.getType(),
                            account.getBalance(),
                            account.getState(),
                            Optional.ofNullable(clientResponseDto).map(ClientResponseDto::name).orElse("Unknown"),
                            account.getNumber()
                    );
                })
                .toList();
    }

    private ClientResponseDto parseClientResponse(String response) {
        try {
            return objectMapper.readValue(response, ClientResponseDto.class);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            return null;
        }
    }
}
