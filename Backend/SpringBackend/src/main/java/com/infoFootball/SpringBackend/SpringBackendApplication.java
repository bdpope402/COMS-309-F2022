package com.infoFootball.SpringBackend;

import com.infoFootball.SpringBackend.Login.LoginController;
import com.infoFootball.SpringBackend.Register.RegisterController;
import com.infoFootball.SpringBackend.Schedule.GameController;
import com.infoFootball.SpringBackend.User.UserController;
import com.infoFootball.SpringBackend.Player.PlayerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
@Import({LoginController.class, RegisterController.class, UserController.class, PlayerController.class, GameController.class})
public class SpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}

}