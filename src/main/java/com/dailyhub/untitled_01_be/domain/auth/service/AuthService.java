package com.dailyhub.untitled_01_be.domain.auth.service;

import com.dailyhub.untitled_01_be.domain.auth.dto.request.EmailRequest;
import com.dailyhub.untitled_01_be.domain.auth.dto.request.LoginRequest;
import com.dailyhub.untitled_01_be.domain.user.domain.Status;
import com.dailyhub.untitled_01_be.domain.user.domain.User;
import com.dailyhub.untitled_01_be.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    
    public Status findUserByEmail(EmailRequest emailRequest) {
        // TODO.. 이메일 형식 검증 정규표현식 로직 추가
        String email = emailRequest.getEmail();

        User findUser = userRepository.findUserByEmail(email);
        if (findUser == null) {
            return null;
        }

        return findUser.getStatus();
    }

    /**
     * 로그인의 경우, 초기 화면에서 이미 존재하는 사용자인지 검증하고 넘어온다.
     * 따라서, 여기서는 비밀번호 입력만 검증하면 된다.
     */
    public User login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user == null) {
            return null;
        }

        return user;
    }


}
