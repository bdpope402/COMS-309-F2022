package com.springboot.app.user;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    //List of all users
    HashMap<String, User> userList = new HashMap<>();

    @GetMapping("/users")
    public HashMap<String, User> getUsers(){
        return userList;
    }

//    @PostMapping("/users/create")
//    public String createUser(@RequestParam String name, @RequestParam String role) {
//        //User newUser = new User(name, role);
//        //userList.put(newUser.getName(), newUser);
//        //return "New user " + newUser.getName() + " Added as " + newUser.getRole();
//    }

    @PostMapping("/users/create2")
    public String createUser(@RequestBody User newUser) {
        userList.put(newUser.getName(), newUser);
        return "New user " + newUser.getName() + " Added as " + newUser.getRole();
    }

    @PutMapping("/users/{name}")
    public String updateUser(@RequestParam String oldName, @RequestBody User newUser) {
        userList.replace(oldName, newUser);
        return "Updated " + oldName;
    }

    @DeleteMapping("/users/{name}")
    public String deleteUser(@RequestParam String name) {
        userList.remove(name);
        return "User " + name + " was deleted";
    }
}
