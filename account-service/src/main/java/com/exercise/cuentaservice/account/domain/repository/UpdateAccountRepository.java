package com.exercise.cuentaservice.account.domain.repository;

import com.exercise.cuentaservice.account.domain.entities.Account;

public interface UpdateAccountRepository {
    Account update(Account account);

    String findNumberById(Long id);
}
