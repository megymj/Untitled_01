package com.dailyhub.untitled_01_be.domain.auth.service;

import com.dailyhub.untitled_01_be.domain.auth.dto.request.EmailRequest;
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
        String email = emailRequest.getEmail();

        User findUser = userRepository.findUserByEmail(email);
        if (findUser == null) {
            return null;
        }

        return findUser.getStatus();
    }
}
