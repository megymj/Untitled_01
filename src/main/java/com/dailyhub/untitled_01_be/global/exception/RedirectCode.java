package com.dailyhub.untitled_01_be.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RedirectCode {


    // Auth
    AUTH_EMAIL_EXIST(HttpStatus.OK, "S01_AUTH", "이미 가입된 사용자입니다. 로그인 화면으로 이동합니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
