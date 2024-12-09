package com.dailyhub.untitled_01_be.domain.auth.controller;

import com.dailyhub.untitled_01_be.domain.auth.dto.request.EmailRequest;
import com.dailyhub.untitled_01_be.domain.auth.service.AuthService;
import com.dailyhub.untitled_01_be.domain.user.domain.Status;
import com.dailyhub.untitled_01_be.global.common.ApiResponse;
import com.dailyhub.untitled_01_be.global.exception.ErrorCode;
import com.dailyhub.untitled_01_be.global.exception.SuccessCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    /**
     * 1. 초기 화면에서 이메일 입력 후 '계속'버튼 선택 시 진행되는 로직
     */
    @PostMapping("/validate-email")
    public ResponseEntity<ApiResponse<Status>> findUserByEmail(@RequestBody EmailRequest emailRequest) {
        Status status = authService.findUserByEmail(emailRequest);

        if (status == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(ErrorCode.AUTH_EMAIL_NOT_FOUND, null));
        } else {
            if (status == Status.INACTIVE) {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(ApiResponse.error(ErrorCode.AUTH_EMAIL_INACTIVE, null));
            } else if (status == Status.VERIFIED) {
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(ApiResponse.success(SuccessCode.AUTH_EMAIL_EXIST_AND_VERIFIED, null));
            }
            return ResponseEntity.ok(ApiResponse.success(SuccessCode.AUTH_EMAIL_EXIST_AND_ACTIVE, null));
        }
    }

}
