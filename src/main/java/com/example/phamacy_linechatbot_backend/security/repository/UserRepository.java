package com.example.phamacy_linechatbot_backend.security.repository;

import com.example.phamacy_linechatbot_backend.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
