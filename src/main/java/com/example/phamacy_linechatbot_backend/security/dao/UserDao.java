package com.example.phamacy_linechatbot_backend.security.dao;

import com.example.phamacy_linechatbot_backend.security.entity.User;

public interface UserDao {
    User getUser(Long id);
}
