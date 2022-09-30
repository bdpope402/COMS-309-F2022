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

    @GetMapping("login/register")
    public String newUser(@RequestParam User newUser) {
        //set random num id here?? @Bryan
        // userRepository.save(newUser); //Commenting this out because it's breaking the build -BP
        return "Saved";
    }
}