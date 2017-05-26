package com.zg.service.impl;

import com.zg.dao.UserMapper;
import com.zg.model.User;
import com.zg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByID(int id) {
        return userMapper.findByID(id);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }

    @Override
    public int insert(User user) {
        userMapper.insert(user);
        return user.getId();
    }
}
