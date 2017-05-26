package com.zg.service;

import com.zg.model.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User findByID(int id);

    int insert(User user);

    int update(User user);

    int delete(int id);
}
