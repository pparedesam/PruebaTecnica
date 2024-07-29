package com.exercise.cuentaservice.common.handlers;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;

public enum MessageType {
    SUCCESS(1),
    INFORMATION(2),
    ERROR(3),
    EXCEPTION(4),
    UNKNOWN(0);

    private final int code;

    private MessageType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static MessageType getMessageType(int httpStatus) {
        try {
            HttpStatus status = HttpStatus.valueOf(httpStatus);
            if (Series.SUCCESSFUL.equals(status.series())) {
                return SUCCESS;
            } else if (httpStatus == HttpStatus.UNPROCESSABLE_ENTITY.value()) {
                return INFORMATION;
            } else if (Series.INFORMATIONAL.equals(status.series())) {
                return INFORMATION;
            } else if (Series.CLIENT_ERROR.equals(status.series())) {
                return ERROR;
            } else {
                return Series.SERVER_ERROR.equals(status.series()) ? EXCEPTION : UNKNOWN;
            }
        } catch (IllegalArgumentException var2) {
            return UNKNOWN;
        }
    }
}
