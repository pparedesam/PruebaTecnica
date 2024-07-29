package com.exercise.cuentaservice.account.domain.repository;

import com.exercise.cuentaservice.account.domain.entities.Account;

import java.util.List;

public interface GetAccountRepository {
    List<Account> findAll();

    Account findById(Long idAccount);

    String  findTopByOrderByNumberDesc();
}
