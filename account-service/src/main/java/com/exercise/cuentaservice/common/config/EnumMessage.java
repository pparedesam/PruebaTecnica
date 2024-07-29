package com.exercise.cuentaservice.common.config;

import lombok.Getter;

@Getter
public enum EnumMessage {

    SUCCESS("La petición se realizó correctamente"),
    ERROR_PROCESSING("Error processing"),
    VALIDATION_ERROR("Validation error");


    private final String message;

    EnumMessage(String message) {
        this.message = message;

    }


}
