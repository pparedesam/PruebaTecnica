package com.exercise.cuentaservice.account.infraestructure.repository;

import com.exercise.cuentaservice.account.domain.entities.Account;
import com.exercise.cuentaservice.account.domain.repository.CreateAccountRepository;
import com.exercise.cuentaservice.account.domain.repository.DeleteAccountRepository;
import com.exercise.cuentaservice.account.domain.repository.GetAccountRepository;
import com.exercise.cuentaservice.account.domain.repository.UpdateAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRepositoryImpl implements GetAccountRepository, CreateAccountRepository, UpdateAccountRepository, DeleteAccountRepository {
    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Override
    public Account create(Account account) {
        return accountJpaRepository.save(account);
    }

    @Override
    public void deleteById(Long idAccount) {

        accountJpaRepository.deleteById(idAccount);
    }

    @Override
    public String findNumberById(Long idAccount) {
        return accountJpaRepository.findNumberById(idAccount);
    }

    @Override
    public boolean existsById(Long idAccount) {
        return accountJpaRepository.existsById(idAccount);
    }

    @Override
    public List<Account> findAll() {
        return accountJpaRepository.findAll();
    }

    @Override
    public Account findById(Long idAccount) {
        return accountJpaRepository.findById(idAccount).orElse(null);
    }

    @Override
    public String findTopByOrderByNumberDesc() {
        return accountJpaRepository.findMaxNumber();
    }

    @Override
    public Account update(Account account) {
        return accountJpaRepository.save(account);
    }
}
