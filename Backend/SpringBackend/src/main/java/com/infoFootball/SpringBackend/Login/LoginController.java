package com.infoFootball.SpringBackend.Login;
import com.infoFootball.SpringBackend.User.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  Springboot controller for login
 */
public class LoginController {

    UserRepository userRepository;

//    /**
//     * Main login function, uses other functions to check for correct user then returns
//     * the user if everything matches and exists
//     * @param password User inputed password
//     * @return User JSON object
//     */
//    @GetMapping("login/{username}")
//    public boolean login(@RequestParam String password) {
//        userRepository.
//    }

//    /**
//     * Compares the password of the login to the database
//     * @param returningUser User object trying to login
//     * @param password Password that user is using
//     * @return true if same false if different
//     */
//    public boolean comparePassword(User returningUser, String password){
//        if(returningUser.getPassword().equals(password)){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

}
