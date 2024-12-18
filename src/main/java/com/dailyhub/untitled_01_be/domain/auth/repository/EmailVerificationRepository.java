package com.dailyhub.untitled_01_be.domain.auth.repository;

import com.dailyhub.untitled_01_be.domain.auth.domain.EmailVerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationRepository extends JpaRepository<EmailVerificationCode, Long> {
    EmailVerificationCode findByEmailAndCode(String email, String code);
}
