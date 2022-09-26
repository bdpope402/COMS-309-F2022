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

    private UserRepository userRepository;

    @GetMapping("login/register/{email}")
    public String newUser(@PathVariable String email, @RequestParam User newUser) {
        newUser.setEmail(email);
        userRepository.save(newUser);
        return "Saved";
    }
}
