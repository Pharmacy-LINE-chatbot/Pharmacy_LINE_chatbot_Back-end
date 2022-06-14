package com.example.phamacy_linechatbot_backend.security.service;

import com.example.phamacy_linechatbot_backend.security.dao.UserDao;
import com.example.phamacy_linechatbot_backend.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}
