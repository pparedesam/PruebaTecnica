package com.exercise.personservice.common.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class ResponseUtil {
    public ResponseUtil() {}

    public static <T> ResponseEntity<ApiResponseCommon<T>> createResponse(HttpStatus httpStatus, MessageType messageType, String message, T data, Object description) {
        List<String> descriptionList = description instanceof List ? (List<String>) description : (description != null ? List.of(description.toString()) : Collections.emptyList());

        ApiResponseCommon<T> apiResponse = new ApiResponseCommon<>(
                data,
                httpStatus.value(),
                messageType.getCode(),
                message,
                descriptionList,
                descriptionList
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }

    public static <T> ResponseEntity<ApiResponseCommon<T>> createSuccessResponse(HttpStatus httpStatus, String successMessage, T data, Object description) {
        return createResponse(httpStatus, MessageType.SUCCESS, successMessage, data, description);
    }

    public static <T> ResponseEntity<ApiResponseCommon<T>> createInformationResponse(HttpStatus httpStatus, String infoMessage, Object description) {
        return createResponse(httpStatus, MessageType.INFORMATION, infoMessage, null, description);
    }

    public static <T> ResponseEntity<ApiResponseCommon<T>> createErrorResponse(HttpStatus httpStatus, String errorMessage, Object description) {
        return createResponse(httpStatus, MessageType.ERROR, errorMessage, null, description);
    }

    public static <T> ResponseEntity<ApiResponseCommon<T>> createExceptionResponse(HttpStatus httpStatus, String errorMessage, Object description, Exception exception) {
        return createResponse(httpStatus, MessageType.EXCEPTION, errorMessage, null, description);
    }
}
