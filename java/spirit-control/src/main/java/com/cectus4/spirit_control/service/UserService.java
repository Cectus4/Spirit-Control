package com.cectus4.spirit_control.service;

import com.cectus4.spirit_control.model.User;
import java.util.List;


public interface UserService {

    List<User> getUsers();
    User saveUser(User user);
    User findUserByEmail(String email);
    User updateUser(User user);
    void deleteUser(String email);
}
