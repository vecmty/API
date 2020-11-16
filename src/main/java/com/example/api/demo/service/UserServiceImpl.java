package com.example.api.demo.service;

import com.example.api.demo.exception.MyNotFoundException;
import com.example.api.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();
    private long counter = 1;

    @Override
    public User create(User user) {
        long id = counter++;
        user.setId(id);
        users.add(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        int index = getIndex(id);
        users.remove(index);
    }

    @Override
    public User getById(Long id) {
        int index = getIndex(id);
        return users.get(index);
    }

    private int getIndex(Long id) {
        for (int i = 0; i < users.size(); i++) {
            User dbUser = users.get(i);
            Long userId = dbUser.getId();
            if (userId.equals(id)) {
                return i;
            }
        }
        throw new MyNotFoundException(String.format("User not found with id = %d", id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User update(User user, Long id) {
        int index = getIndex(id);
        user.setId(id);
        User dbUser = users.get(index);
        BeanUtils.copyProperties(user, dbUser);
        return dbUser;
    }

}
