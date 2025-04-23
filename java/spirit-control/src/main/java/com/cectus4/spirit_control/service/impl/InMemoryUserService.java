package com.cectus4.spirit_control.service.impl;

import com.cectus4.spirit_control.model.User;
import com.cectus4.spirit_control.repository.InMemoryUserDAO;
import com.cectus4.spirit_control.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryUserService implements UserService {

    InMemoryUserDAO userDAO;

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(String email) {
        userDAO.deleteUser(email);
    }

}
