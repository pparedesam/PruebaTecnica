package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.mapper.ClientMapper;
import com.exercise.personservice.client.application.port.GetClientsPort;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetClientsUseCase implements GetClientsPort {

    private final GetClientRepository getClientRepository;

    @Autowired
    public GetClientsUseCase(GetClientRepository getClientRepository) {
        this.getClientRepository = getClientRepository;
    }

    @Override
    public List<ClientResponseDto> execute() {
        return getClientRepository.findAll().stream()
                .map(ClientMapper::clientToClientResponseDto)
                .toList();
    }
}
