package com.infoFootball.SpringBackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Springboot controller for registering a user
 */
@RestController
public class RegisterController {

    @GetMapping("login/register/{email}")
    public void newUser(@PathVariable String email, @RequestParam UserID newUser) {
        newUser.setEmail(email);
    }
}
