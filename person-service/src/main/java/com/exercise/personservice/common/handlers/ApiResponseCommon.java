package com.exercise.personservice.common.handlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ApiResponseCommon<T> {

    @JsonProperty("data")
    private T data;
    @JsonProperty("code")
    private int code;
    @JsonProperty("messageType")
    private int messageType;
    @JsonProperty("message")
    private String message;
    @JsonProperty("description")
    private List<String> description;
    @JsonProperty("errors")
    private List<String> errors;

    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiResponseCommon() {}

    public ApiResponseCommon(T data, int code, int messageType, String message) {
        this.data = data;
        this.code = code;
        this.messageType = messageType;
        this.message = message;
        this.description = Collections.emptyList();
        this.errors = Collections.emptyList();
    }

    public ApiResponseCommon(T data, int code, int messageType, String message, List<String> description, List<String> errors) {
        this.data = data;
        this.code = code;
        this.messageType = messageType;
        this.message = message;
        this.description = description != null ? description : Collections.emptyList();
        this.errors = errors != null ? errors : Collections.emptyList();
    }
}
