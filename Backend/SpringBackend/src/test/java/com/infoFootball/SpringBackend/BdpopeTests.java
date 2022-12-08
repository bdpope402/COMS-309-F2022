package com.infoFootball.SpringBackend;

import com.infoFootball.SpringBackend.Player.Player;
import com.infoFootball.SpringBackend.Player.PlayerRespository;
import com.infoFootball.SpringBackend.Register.RegisterController;
import com.infoFootball.SpringBackend.User.User;
import com.infoFootball.SpringBackend.User.UserRepository;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Test;
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
    PlayerRespository playerRepository;

    @Before
    public void Setup(){
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testNewPlayer() throws Exception {
        JSONObject jsonPlayer = new JSONObject();
        jsonPlayer.put("firstName", "testplayer");
        jsonPlayer.put("lastName", "Doe");
        jsonPlayer.put("playerNum", 420);

        Player newPlayer = new Player("testPlayer", "Doe", "12");

        Response response = RestAssured.given();
                .header("Content-Type", "application/json")
                .body(jsonPlayer.toString()) //Send in json USER
                .when().request("POST", "/player/new"); //The url and request type

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        //Check that it returns a success
        String returnString = response.getBody().asString();
        assertEquals("Success", returnString);
    }


}
