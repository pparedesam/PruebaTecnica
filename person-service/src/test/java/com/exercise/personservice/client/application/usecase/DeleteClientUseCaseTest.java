package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.DeleteClientRepository;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import com.exercise.personservice.person.application.port.DeletePersonPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class DeleteClientUseCaseTest {
    @Mock
    private DeleteClientRepository deleteClientRepository;

    @Mock
    private GetClientRepository getClientRepository;

    @Mock
    private DeletePersonPort deletePersonPort;

    @InjectMocks
    private DeleteClientUseCase deleteClientUseCase;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testDeleteById() {


        when(getClientRepository.findById(any())).thenReturn(mock(Client.class,RETURNS_MOCKS));

        doNothing().when(deleteClientRepository).deleteById(any());
        doNothing().when(deletePersonPort).deleteById(any());
        deleteClientUseCase.deleteById(1L);
        verify(deleteClientRepository,times(1)).deleteById(any());


    }
}

