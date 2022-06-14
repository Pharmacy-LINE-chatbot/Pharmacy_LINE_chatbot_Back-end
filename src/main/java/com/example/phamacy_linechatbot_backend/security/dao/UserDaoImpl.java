package com.example.phamacy_linechatbot_backend.security.dao;

import com.example.phamacy_linechatbot_backend.security.entity.User;
import com.example.phamacy_linechatbot_backend.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }
}
