package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Math;
import java.util.Random;

@RestController
public class ID {

    @GetMapping("/queue")
    //Gets username and company
    public String ID(@RequestParam(value = "name", defaultValue = "null") String name,
                     @RequestParam(value = "line", defaultValue = "null") String line) {

        //Return a formatted string to display
        return String.format("Hello %s, you are number %s, in line.", name, line);
    }
}
