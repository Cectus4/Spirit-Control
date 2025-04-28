package com.cectus4.spirit_control.repository;

import com.cectus4.spirit_control.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteById(Long id);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User findUserById(long id);
}
