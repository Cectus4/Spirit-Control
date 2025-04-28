package com.cectus4.spirit_control.controllers;

import com.cectus4.spirit_control.model.User;
import com.cectus4.spirit_control.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spirit/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("save")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "Saved";
    }

    @GetMapping("find-by-email/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping("find-by-username/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @GetMapping("find-by-id/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PutMapping("update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

}
