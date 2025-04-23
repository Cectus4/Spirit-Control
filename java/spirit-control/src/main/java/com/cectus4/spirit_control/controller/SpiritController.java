package com.cectus4.spirit_control.controller;

import com.cectus4.spirit_control.model.User;
import com.cectus4.spirit_control.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/spirit")
@AllArgsConstructor
public class SpiritController {

    private final UserService spiritService;

    @GetMapping()
    public List<User> getUsers() {
        return spiritService.getUsers();
    }

}
