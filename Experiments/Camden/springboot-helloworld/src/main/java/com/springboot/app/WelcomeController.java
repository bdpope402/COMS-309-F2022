package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/w")
    public String welcome(){
        return "Welcome!! I think this is working...";
    }
}
