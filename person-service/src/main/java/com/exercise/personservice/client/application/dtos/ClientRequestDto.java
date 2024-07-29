package com.exercise.personservice.client.application.dtos;

public record ClientRequestDto(
        Long idClient,
        String name,
        String address,
        String phone,
        String password,
        Boolean state
) {
}
