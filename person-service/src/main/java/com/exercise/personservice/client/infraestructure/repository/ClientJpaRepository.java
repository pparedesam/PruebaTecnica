package com.exercise.personservice.client.infraestructure.repository;

import com.exercise.personservice.client.domain.entities.Client;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientJpaRepository extends JpaRepository<Client, Long> {
    void deleteById(@NonNull Long idPerson);

    List<Client> findAllByPerson_Name(String name);

}
