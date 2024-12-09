package com.dailyhub.untitled_01_be.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Common
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E01_COMMON", "서버 내부 오류");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
