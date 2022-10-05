package com.infoFootball.SpringBackend.Login;
import com.infoFootball.SpringBackend.User.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  Springboot controller for login
 */
public class LoginController {

    UserRepository userRepository;

    /**
     * Main login function, uses other functions to check for correct user then returns
     * the user if everything matches and exists
     * @param password User inputed password
     * @return User JSON object
     */
    @GetMapping("login/{username}")
    public User login(@PathVariable String username, @RequestParam String password) {
        User curUser = userRepository.findByUsername(username);
        if(comparePassword(curUser, password)) {
            return curUser;
        } else {
            return null;
        }
    }

    /**
     * Compares the password of the login to the database
     * @param returningUser User object trying to login
     * @param password Password that user is using
     * @return true if same false if different
     */
    public boolean comparePassword(User returningUser, String password){
        if(returningUser.getPassword().equals(password)){
            return true;
        } else{
            return false;
        }
    }

}
