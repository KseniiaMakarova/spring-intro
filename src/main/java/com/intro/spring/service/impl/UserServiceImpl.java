package com.intro.spring.service.impl;

import com.intro.spring.dao.UserDao;
import com.intro.spring.model.User;
import com.intro.spring.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.getAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.get(id);
    }
}
