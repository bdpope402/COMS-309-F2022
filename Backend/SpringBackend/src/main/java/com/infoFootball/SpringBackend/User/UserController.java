package com.infoFootball.SpringBackend.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    LaptopRepository laptopRepository;

    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    /**
     * Gets all users
     * @return list of all users
     */
    @GetMapping(path = "/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * Gets a user by username
     * @param username username of user
     * @return user related to username
     */
    @GetMapping(path = "/users/{username}")
    User getUserByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    //Need to factor this to make it work with michaels edit user page
    /**
     * Updates user
     * @param username username of user
     * @param request the updated user info
     * @return new user
     */
    @PutMapping("/users/{username}")
    User updateUser(@PathVariable String username, @RequestBody User request){
        User user = userRepository.findByUsername(username);
        if(user == null)
            return null;
        userRepository.save(request);
        return userRepository.findByUsername(username);
    }

    /**
     * Deletes a user by username
     * @param username username of user to be deleted
     * @return if user was successfully deleted
     */
    @DeleteMapping(path = "/users/{username}")
    String deleteUser(@PathVariable String username){
        userRepository.deleteByUsername(username);
        return success;
    }

//    @PutMapping("/users/{userId}/laptops/{laptopId}") //Assign this to profile information?
//    String assignLaptopToUser(@PathVariable int userId,@PathVariable int laptopId){
//        User user = userRepository.findById(userId);
//        Laptop laptop = laptopRepository.findById(laptopId);
//        if(user == null || laptop == null)
//            return failure;
//        laptop.setUser(user);
//        user.setLaptop(laptop);
//        userRepository.save(user);
//        return success;
//    }
}