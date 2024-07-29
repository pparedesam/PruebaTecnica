package com.exercise.cuentaservice.account.domain.repository;

import com.exercise.cuentaservice.account.domain.entities.Account;

public interface CreateAccountRepository {
    Account create(Account account);
}
