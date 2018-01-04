package com.chat2.service;

import com.chat2.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    User findUserById(int id);

    List<User> findAll();
}
