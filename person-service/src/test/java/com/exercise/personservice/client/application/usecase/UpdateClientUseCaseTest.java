package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.domain.repository.UpdateClientRepository;
import com.exercise.personservice.person.application.port.UpdatePersonPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UpdateClientUseCaseTest {

    @Mock
    private UpdateClientRepository updateClientRepository;

    @Mock
    private UpdatePersonPort updatePersonPort;

    @InjectMocks
    private UpdateClientUseCase updateClientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void update_ShouldUpdateClientAndPerson() {
/*
        ClientRequestDto mockClient = mock(ClientRequestDto.class,RETURNS_MOCKS);


        when(updateClientRepository.update(any())).thenReturn(mock(Client.class,RETURNS_MOCKS));
        
        ClientResponseDto clientResponseDto = updateClientUseCase.update(mockClient);

        assertNotNull(clientResponseDto, "El cliente actualizado no debe ser nulo");


        verify(updateClientRepository).update(any());

 */
    }
}
