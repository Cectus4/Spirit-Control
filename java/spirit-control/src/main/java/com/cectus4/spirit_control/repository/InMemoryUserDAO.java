package com.cectus4.spirit_control.repository;

import com.cectus4.spirit_control.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryUserDAO {

    private final List<User> USERS = new ArrayList<User>();

    public List<User> getUsers() {
        return USERS;
    }

    public User saveUser(User user) {
        USERS.add(user);
        return user;
    }

    public User findUserByEmail(String email) {
        return USERS.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    public User updateUser(User user) {
        var userIndex = IntStream.range(0, USERS.size())
                .filter(id -> USERS.get(id).getEmail().equals(user.getEmail())).findFirst().orElse(-1);
        return (userIndex!=-1) ? null : USERS.set(userIndex, user);
    }

    public void deleteUser(String email) {
        var user = findUserByEmail(email);
        if(user!=null){
            USERS.remove(user);
        }
    }
}
