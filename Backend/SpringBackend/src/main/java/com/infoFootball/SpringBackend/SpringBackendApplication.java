package com.infoFootball.SpringBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}

	@GetMapping("/test")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping("/login")
	public String login(@RequestParam(value = "name", defaultValue = "Kevin") String name) {
		return String.format("Welcome back %s!", name);
	}

	@GetMapping("/welcome")
	public String welcome(@RequestParam(value = "name", defaultValue = "Kevin") String name) {
		return String.format("Welcome back %s!", name);
	}



}