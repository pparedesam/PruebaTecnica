package com.exercise.cuentaservice.account.infraestructure.repository;

import com.exercise.cuentaservice.account.domain.entities.Account;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account,Long> {
    void deleteById(@NonNull Long idAccount);

    @Query("SELECT MAX(a.number) FROM Account a")
    String findMaxNumber();

    @Query("SELECT a.number FROM Account a WHERE a.id = :idAccount")
    String findNumberById(@Param("idAccount") Long idAccount);
}
