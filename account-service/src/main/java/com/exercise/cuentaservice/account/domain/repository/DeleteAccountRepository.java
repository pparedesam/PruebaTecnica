package com.exercise.cuentaservice.account.domain.repository;

public interface DeleteAccountRepository
{
    void deleteById(Long idAccount);

    boolean existsById(Long idAccount);
}
