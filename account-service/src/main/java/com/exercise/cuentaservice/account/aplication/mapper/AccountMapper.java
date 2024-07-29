package com.exercise.cuentaservice.account.aplication.mapper;

import com.exercise.cuentaservice.account.aplication.dtos.AccountRequestDto;
import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.domain.entities.Account;

public class AccountMapper {

    private AccountMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Account accountDtoToAccount(AccountRequestDto dto) {
        return Account.builder()

                .type(dto.accountType())
                .balance(dto.initialBalance())
                .state(dto.status())
                .idClient(dto.idClient())

                .build();
    }

    public static AccountResponseDto accountToAccountDto(Account account, String clientName) {

        return new AccountResponseDto(
                account.getId(),
                account.getType(),
                account.getBalance(),
                account.getState(),
                clientName,
                account.getNumber()

        );
    }


}
