package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ID {

    @GetMapping("/ID")
    //Gets username and company
    public String ID(@RequestParam(value = "name", defaultValue = "null") String name,
                     @RequestParam(value = "company", defaultValue = "null") String company) {

        //rand var for random ID (would add to database in future)
        Random rand = new Random();

        //Return a formatted string to display
        return String.format("Hello %s, your ID is %d, welcome to %s", name, rand.nextInt()%5, company);
    }
}
