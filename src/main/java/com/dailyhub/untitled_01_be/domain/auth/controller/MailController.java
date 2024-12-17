package com.dailyhub.untitled_01_be.domain.auth.controller;

import com.dailyhub.untitled_01_be.domain.auth.dto.request.EmailRequest;
import com.dailyhub.untitled_01_be.domain.auth.service.MailService;
import com.dailyhub.untitled_01_be.global.common.ApiResponse;
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
@RequestMapping("/api/mail")
public class MailController {

    private final MailService mailService;

    @PostMapping("/auth-code")
    public ResponseEntity<ApiResponse<Object>> sendAuthCode(@RequestBody EmailRequest emailRequest) {
        // 인증 코드 생성
        String authCode = mailService.generateAuthCode();

        // todo.. 추후 이메일 형식 검증 로직 구현 필요
        String email = emailRequest.getEmail();

        // 이메일 전송
        mailService.sendAuthCode(email, authCode);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(SuccessCode.AUTH_SEND_CODE_SUCCESS, authCode));
    }
}
