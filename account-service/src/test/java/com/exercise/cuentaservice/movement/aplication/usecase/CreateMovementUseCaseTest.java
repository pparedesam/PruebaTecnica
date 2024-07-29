package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.account.domain.entities.Account;
import com.exercise.cuentaservice.account.domain.repository.GetAccountRepository;
import com.exercise.cuentaservice.account.domain.repository.UpdateAccountRepository;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementRequestDto;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.CreateMovementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class CreateMovementUseCaseTest {
    @Mock
    private CreateMovementRepository createMovementRepository;

    @Mock
    private GetAccountRepository getAccountRepository;

    @Mock
    private UpdateAccountRepository updateAccountRepository;

    @InjectMocks
    private CreateMovementUseCase createMovementUseCase;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateMovementWithSufficientBalance() {

        MovementRequestDto requestDto = mock(MovementRequestDto.class,RETURNS_MOCKS);
        Account mockAccount = mock(Account.class,RETURNS_MOCKS);
        Movement mockMovement = mock(Movement.class,RETURNS_MOCKS);

        when(getAccountRepository.findById(any())).thenReturn(mockAccount);
        when(createMovementRepository.create(any(Movement.class))).thenReturn(mockMovement);
        when(updateAccountRepository.update(any(Account.class))).thenReturn(mockAccount);

        MovementResponseDto response = createMovementUseCase.execute(requestDto);

        assertNotNull(response);
        verify(getAccountRepository, times(1)).findById(anyLong());
        verify(createMovementRepository, times(1)).create(any(Movement.class));
        verify(updateAccountRepository, times(1)).update(any(Account.class));
    }



}