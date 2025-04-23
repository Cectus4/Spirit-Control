package com.cectus4.spirit_control.service;

import com.cectus4.spirit_control.User;
import java.util.List;


public interface UserService {

    List<User> getUsers();
    User saveUser(User user);
    User getUserByEmail(String email);
    User updateUser(User user);
    void deleteUser(User user);
}
