package com.zg.service.impl;

import com.zg.dao.UserMapper;
import com.zg.model.User;
import com.zg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByID(int id) {
        return userMapper.findByID(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
