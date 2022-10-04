package com.infoFootball.SpringBackend.Register;

import com.infoFootball.SpringBackend.User.*;
import org.springframework.web.bind.annotation.*;

/**
 *  Springboot controller for registering a user
 */
@RestController
public class RegisterController {

    private UserRepository userRepository;

    @PostMapping("login/register")
    public String newUser(@RequestParam User newUser) {
        userRepository.save(newUser); //Commenting this out because it's breaking the build -BP
        return "Saved";
    }
}