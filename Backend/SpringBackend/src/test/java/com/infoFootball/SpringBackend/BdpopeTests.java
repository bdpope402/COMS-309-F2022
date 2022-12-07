package com.infoFootball.SpringBackend;

import com.infoFootball.SpringBackend.Player.PlayerRespository;
import com.infoFootball.SpringBackend.Register.RegisterController;
import com.infoFootball.SpringBackend.User.User;
import com.infoFootball.SpringBackend.User.UserRepository;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import org.json.JSONObject;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BdpopeTests {

    @LocalServerPort
    int port;

    @Autowired
    PlayerRespository userRepository;
}
