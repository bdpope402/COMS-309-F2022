package com.infoFootball.SpringBackend;

import com.infoFootball.SpringBackend.Login.LoginController;
import com.infoFootball.SpringBackend.Register.RegisterController;
import com.infoFootball.SpringBackend.User.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
@Import({LoginController.class, RegisterController.class, UserController.class})
public class SpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}

	@GetMapping("/test")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}