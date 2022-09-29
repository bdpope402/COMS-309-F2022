package com.infoFootball.SpringBackend;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *  Springboot controller for login
 */

public class LoginController {
    @GetMapping("login/")
    public boolean checkLogin(User returningUser, String password){
        if(returningUser.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

}
