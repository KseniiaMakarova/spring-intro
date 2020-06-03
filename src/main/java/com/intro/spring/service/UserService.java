package com.intro.spring.service;

import com.intro.spring.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
