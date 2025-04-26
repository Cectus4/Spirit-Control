package com.cectus4.spirit_control.controllers;

import com.cectus4.spirit_control.model.User;
import com.cectus4.spirit_control.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spirit")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("save-user")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "Saved";
    }

    @GetMapping("/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("update-user")
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("delete-user/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }

}
