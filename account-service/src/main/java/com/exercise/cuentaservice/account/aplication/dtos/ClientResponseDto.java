package com.exercise.cuentaservice.account.aplication.dtos;

public record ClientResponseDto(
        Long id,
        String name,
        String address,
        String phone
) {
}
