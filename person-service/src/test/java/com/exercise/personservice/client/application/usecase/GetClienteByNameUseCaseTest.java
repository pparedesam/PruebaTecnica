package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GetClienteByNameUseCaseTest {

    @Mock
    private GetClientRepository getClientRepository;

    @InjectMocks
    private GetClienteByNameUseCase getClienteByNameUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByName() {

        when(getClientRepository.findByName(any())).thenReturn(mock(Client.class,RETURNS_MOCKS));
        ClientResponseDto clientResponseDto = getClienteByNameUseCase.findByName(" ");
        assertNotNull(clientResponseDto);
    }
}
