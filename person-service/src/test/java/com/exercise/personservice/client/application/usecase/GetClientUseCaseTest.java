package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetClientUseCaseTest {

    @Mock
    private GetClientRepository getClientRepository;

    @InjectMocks
    private GetClientUseCase getClientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_ShouldReturnListOfClients() {
        Long idClient = 1L;
        Client mockClient = mock(Client.class,RETURNS_MOCKS);

        when(getClientRepository.findById(idClient)).thenReturn(mockClient);

        ClientResponseDto result =  getClientUseCase.findById(1L);

        assertNotNull(result);

        verify(getClientRepository,times(1)).findById(idClient);
    }
}
