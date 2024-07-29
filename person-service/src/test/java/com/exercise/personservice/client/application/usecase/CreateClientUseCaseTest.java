package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.CreateClientRepository;
import com.exercise.personservice.person.application.port.CreatePersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CreateClientUseCaseTest {
    @Mock
    private CreateClientRepository createClientRepository;

    @Mock
    private CreatePersonPort createPersonPort;

    @InjectMocks
    private CreateClientUseCase createClientUseCase;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void execute() {



        ClientRequestDto clientRequestDto = mock(ClientRequestDto.class); // Configura tu DTO

        when(createPersonPort.execute(any())).thenReturn(mock(Person.class,RETURNS_MOCKS));

        createClientUseCase.execute(clientRequestDto);

        verify(createPersonPort).execute(any(Person.class));
        verify(createClientRepository).create(any(Client.class));
    }
}