package com.exercise.cuentaservice.account.aplication.port;

import com.exercise.cuentaservice.account.aplication.dtos.AccountRequestDto;
import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;


public interface UpdateAccountPort {
    AccountResponseDto update(AccountRequestDto accountRequestDto);
}
