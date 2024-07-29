package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class GetClientsUseCaseTest {

    @Mock
    private GetClientRepository getClientRepository;

    @InjectMocks
    private GetClientsUseCase getClientsUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_ShouldReturnListOfClients() {

        Client client1 = new Client();
        Client client2 = new Client();
        List<Client> expectedClients = Arrays.asList(client1, client2);

        when(getClientRepository.findAll()).thenReturn(expectedClients);

        List<Client> result = getClientsUseCase.execute();

        assertNotNull(result, "El resultado no debe ser nulo");
        assertEquals(expectedClients.size(), result.size(), "El tamaño de la lista debe coincidir");
    }
}
