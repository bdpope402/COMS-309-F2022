package com.infoFootball.SpringBackend.Player;
import java.util.List;

import com.infoFootball.SpringBackend.User.User;
import com.infoFootball.SpringBackend.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @todo update all of this to player junk
 * This class is for controlling player entry and all the critical
 * bits for adding, updating, getting, and deleting players
 */
@RestController
public class PlayerController {
    @Autowired
    UserRepository userRepository;

    final private String success = "{\"message\":\"success\"}";
    final private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/players")
    List<User> getAllPlayers(){
        return userRepository.findAll();
    }
}