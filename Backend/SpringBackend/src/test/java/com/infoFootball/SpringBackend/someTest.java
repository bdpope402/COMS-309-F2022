package com.infoFootball.SpringBackend;

import com.infoFootball.SpringBackend.Register.RegisterController;
import com.infoFootball.SpringBackend.User.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = RegisterController.class)
@RunWith(SpringRunner.class)
public class someTest {

    @LocalServerPort
    int port;

    @Autowired
    UserRepository userRepository;

    //This will run before every test
    @Before
    public void Setup(){
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";

    }

    @Test
    public void testCreateUser() {

    }


}
