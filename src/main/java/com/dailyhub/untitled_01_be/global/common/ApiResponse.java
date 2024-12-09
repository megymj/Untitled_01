package com.dailyhub.untitled_01_be.global.common;

import com.dailyhub.untitled_01_be.global.exception.ErrorCode;
import com.dailyhub.untitled_01_be.global.exception.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private final int status;
    private final String code;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success(SuccessCode successCode, T data) {
        return new ApiResponse<>(
                successCode.getHttpStatus().value(),
                successCode.getCode(),
                successCode.getMessage(),
                data
        );
    }

    public static <T> ApiResponse<T> error(ErrorCode errorCode, T data) {
        return new ApiResponse<>(
                errorCode.getHttpStatus().value(),
                errorCode.getCode(),
                errorCode.getMessage(),
                data
        );
    }
}
