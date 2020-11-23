package com.example.api.demo.service;

import com.example.api.demo.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    void delete(Long id);
//    User update(User user, Long id);
    User getById(Long id);
    List<User> getAll();
}
