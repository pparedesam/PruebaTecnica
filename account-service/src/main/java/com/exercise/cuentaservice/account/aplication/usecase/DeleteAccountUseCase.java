package com.exercise.cuentaservice.account.aplication.usecase;

import com.exercise.cuentaservice.account.aplication.port.DeleteAccountPort;
import com.exercise.cuentaservice.account.domain.repository.DeleteAccountRepository;
import com.exercise.cuentaservice.account.infraestructure.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountUseCase implements DeleteAccountPort {

    private final DeleteAccountRepository deleteAccountRepository;

    @Autowired
    public DeleteAccountUseCase(DeleteAccountRepository deleteAccountRepository) {
        this.deleteAccountRepository = deleteAccountRepository;
    }

    @Override
    public void deleteById(Long idAccount) {
        if (!deleteAccountRepository.existsById(idAccount)) {
            throw new AccountNotFoundException("Account with ID " + idAccount + " not found.");
        }
        deleteAccountRepository.deleteById(idAccount);
    }
}
