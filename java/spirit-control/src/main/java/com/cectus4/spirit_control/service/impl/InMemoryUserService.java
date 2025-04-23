package com.cectus4.spirit_control.service.impl;

import com.cectus4.spirit_control.model.User;
import com.cectus4.spirit_control.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InMemoryUserService implements UserService {

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

}
