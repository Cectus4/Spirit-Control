package com.cectus4.spirit_control.service;

import com.cectus4.spirit_control.model.User;
import java.util.List;


public interface UserService {

    List<User> getUsers();
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserById(long id);
}
