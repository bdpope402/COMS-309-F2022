package com.infoFootball.SpringBackend.Login;
import com.infoFootball.SpringBackend.User.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Springboot controller for login
 */
@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;

    /**
     * Main login function, uses other functions to check for correct user then returns
     * the user if everything matches and exists
     * //@param password User inputted password
     * @return User JSON object
     */
    @GetMapping("/login/{username}")
    public User login(@PathVariable("username") String username) {
//    public User login(@PathVariable("username") String username, @RequestParam String password) {
        User curUser = userRepository.findByUsername(username);

        return curUser;

//        if(comparePassword(curUser, password)) {
//            return curUser;
//        } else {
//            //Create a null error user if there is no user errorUser = new User("Bad Password", "Null", "Null", "Null");
//            return errorUser;
//        }
    }

    /**
     * Compares the password of the login to the database
     * @param returningUser User object trying to log in
     * @param password Password that user is using
     * @return true if same, false if different
     */
    public boolean comparePassword(User returningUser, String password){
        return returningUser.getPassword().equals(password);
    }

}
