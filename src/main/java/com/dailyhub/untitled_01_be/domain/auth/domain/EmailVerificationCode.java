package com.dailyhub.untitled_01_be.domain.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "email_verification_codes")
@Entity
public class EmailVerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String code;

    @Column(updatable = false, insertable = false) // DB에서 자동으로 생성되는 값
    private LocalDateTime createdAt;

    @Column(updatable = false, insertable = false) // DB에서 자동으로 생성되는 값
    private LocalDateTime expiresAt;

    @Builder
    public EmailVerificationCode(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
