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

    public User updateUser(User user) {
        var userIndex = IntStream.range(0, USERS.size())
                .filter(id -> USERS.get(id).getId().equals(user.getId())).findFirst().orElse(-1);
        return (userIndex!=-1) ? USERS.set(userIndex, user): null ;
    }

    public void deleteUser(long id) {
        var user = findUserById(id);
        if(user!=null){
            USERS.remove(user);
        }
    }

    public User findUserByEmail(String email) {
        return USERS.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    public User findUserByUsername(String username) {
        return USERS.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    public User findUserById(long id) {
        return USERS.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
