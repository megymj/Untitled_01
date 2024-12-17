package com.dailyhub.untitled_01_be.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    // Common
    SUCCESS(HttpStatus.OK, "S01_COMMON", "요청이 성공적으로 처리되었습니다."),

    // Auth
    AUTH_EMAIL_EXIST_AND_ACTIVE(HttpStatus.OK, "S01_AUTH", "이미 가입된 사용자입니다. 로그인 화면으로 이동합니다."),
    AUTH_EMAIL_EXIST_AND_VERIFIED(HttpStatus.FOUND, "S02_AUTH", "이메일 인증이 완료된 사용자입니다. 회원가입 화면으로 이동합니다."),

    AUTH_LOGIN_SUCCESS(HttpStatus.OK, "S01_LOGIN", "로그인에 성공했습니다."),

    AUTH_SEND_CODE_SUCCESS(HttpStatus.OK, "S01_CODE", "이메일 인증 코드 전송에 성공하셨습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
