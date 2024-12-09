package com.dailyhub.untitled_01_be.domain.user.repository;

import com.dailyhub.untitled_01_be.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
