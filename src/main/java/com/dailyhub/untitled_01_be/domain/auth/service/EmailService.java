package com.dailyhub.untitled_01_be.domain.auth.service;

import com.dailyhub.untitled_01_be.domain.auth.domain.EmailVerificationCode;
import com.dailyhub.untitled_01_be.domain.auth.repository.EmailVerificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailVerificationRepository emailVerificationRepository;

    private static final int AUTH_CODE_LENGTH = 6;

    // 이메일 전송 메서드
    public void sendAuthCode(String toEmail, String authCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("이메일 인증 코드");
        message.setText("인증 코드: " + authCode);

        // Save authCode to DB
        try {
            emailVerificationRepository.save(EmailVerificationCode.builder()
                    .email(toEmail)
                    .code(authCode)
                    .build());

        } catch (Exception e) {
            log.error("Failed to save auth code to DB", e);
            // Handle the exception as needed, e.g., throw a custom exception or return a specific response
        }

        // send email
        try {
            javaMailSender.send(message);
            log.info("Email sent successfully to {}", toEmail);
        } catch (MailException e) {
            log.error("Failed to send email to {}", toEmail, e);
            // Handle the exception as needed, e.g., throw a custom exception or return a specific response
        }
    }

    // 6자리 인증번호 생성
    public String generateAuthCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder authCode = new StringBuilder();

        for (int i = 0; i < AUTH_CODE_LENGTH; i++) {
            authCode.append(random.nextInt(10)); // 0~9 사이의 숫자
        }

        return authCode.toString();
    }


}
