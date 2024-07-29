package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.port.DeleteClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.DeleteClientRepository;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import com.exercise.personservice.person.application.port.DeletePersonPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientUseCase implements DeleteClientPort {

    private final DeleteClientRepository deleteClientRepository;
    private final GetClientRepository getClientRepository;
    private final DeletePersonPort deletePersonPort;

    @Autowired
    public DeleteClientUseCase(DeleteClientRepository deleteClientRepository, GetClientRepository getClientRepository, DeletePersonPort deletePersonPort) {
        this.deleteClientRepository = deleteClientRepository;
        this.getClientRepository = getClientRepository;
        this.deletePersonPort = deletePersonPort;
    }

    @Override
    @Transactional
    public void deleteById(Long idClient) {
        Client client = getClientRepository.findById(idClient);
        deleteClientRepository.deleteById(client.getId());
        deletePersonPort.deleteById(client.getPerson().getId());
    }
}
