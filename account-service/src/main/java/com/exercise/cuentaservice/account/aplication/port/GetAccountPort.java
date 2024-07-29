package com.exercise.cuentaservice.account.aplication.port;

import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;

import java.util.List;

public interface GetAccountPort {
    List<AccountResponseDto> execute();
}
