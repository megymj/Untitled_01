package com.dailyhub.untitled_01_be.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /**
     * CE : Client Error(4xx)
     * SE : Server Error(5xx)
     */

    // Common
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SE01_COMMON", "서버 내부 오류"),

    // Auth
    AUTH_EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "CE01_AUTH", "사용자를 찾을 수 없습니다."),
    AUTH_EMAIL_INACTIVE(HttpStatus.UNAUTHORIZED, "CE02_AUTH", "비활성화된 사용자입니다. 관리자에게 문의하세요."),


    AUTH_LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "CE01_LOGIN", "로그인에 실패했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
