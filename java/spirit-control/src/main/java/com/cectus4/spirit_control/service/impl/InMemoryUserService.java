package com.cectus4.spirit_control.service.impl;

import com.cectus4.spirit_control.User;
import com.cectus4.spirit_control.service.SpiritService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InMemoryUserService implements SpiritService {

    @Override
    public List<User> getUsers() {
        return List.of(
                User.builder().name("mari").age(16).gender(false).mail("mari16@yandex.ru").build(),
                User.builder().name("bebs").age(40).gender(true).mail("bebey@gmail.com").build()
        );
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

}
