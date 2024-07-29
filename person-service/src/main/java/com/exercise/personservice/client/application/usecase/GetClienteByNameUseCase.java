package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.mapper.ClientMapper;
import com.exercise.personservice.client.application.port.GetClientByNamePort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import com.exercise.personservice.client.infraestructure.exception.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class GetClienteByNameUseCase implements GetClientByNamePort {

    private final GetClientRepository getClientRepository;

    @Autowired
    public GetClienteByNameUseCase(GetClientRepository getClientRepository) {
        this.getClientRepository = getClientRepository;
    }

    @Override
    public List<ClientResponseDto> findByName(String name) {

        List<Client> client =  getClientRepository.findByName(name);
        if (client.isEmpty()) {
            throw new ClientNotFoundException("No clients found with the name: " + name);
        }
         return client.stream()
                .map(ClientMapper::clientToClientResponseDto)
                .toList();
    }
}
