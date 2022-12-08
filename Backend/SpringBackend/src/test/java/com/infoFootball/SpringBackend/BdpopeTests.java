package com.infoFootball.SpringBackend;

import com.infoFootball.SpringBackend.Player.Player;
import com.infoFootball.SpringBackend.Player.PlayerRespository;
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

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonPlayer.toString()) //Send in json USER
                .when().request("POST", "/players/new"); //The url and request type

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        //Check that it returns a success
        String returnString = response.getBody().asString();
        assertEquals("Success", returnString);
    }

    @Test
    public void testGetPlayers() throws Exception {
        JSONObject jsonPlayer = new JSONObject();
        jsonPlayer.put("firstName", "John");
        jsonPlayer.put("lastName", "Doe");
        jsonPlayer.put("playerNum", 420);

        JSONObject jsonPlayer2 = new JSONObject();
        jsonPlayer2.put("firstName", "testplayer2");
        jsonPlayer2.put("lastName", "Doe");
        jsonPlayer2.put("playerNum", 421);

        JSONObject jsonPlayer3 = new JSONObject();
        jsonPlayer3.put("firstName", "Jane");
        jsonPlayer3.put("lastName", "Doe");
        jsonPlayer3.put("playerNum", 420);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonPlayer.toString()) //Send in json USER
                .when().request("POST", "/players/new");

        Response response2 = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonPlayer2.toString()) //Send in json USER
                .when().request("POST", "/players/new");

        Response response3 = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonPlayer3.toString()) //Send in json USER
                .when().request("POST", "/players/new");

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        //Check that it returns a success
        String returnString = response.getBody().asString();
        assertEquals("Success", returnString);

        statusCode = response2.getStatusCode();
        assertEquals(200, statusCode);

        //Check that it returns a success
        returnString = response2.getBody().asString();
        assertEquals("Success", returnString);

        statusCode = response3.getStatusCode();
        assertEquals(200, statusCode);

        //Check that it returns a success
        returnString = response3.getBody().asString();
        assertEquals("Success", returnString);

        Response response4 = RestAssured.given()
                .when().request("GET", "/players/num/421");

        //Having trouble comparing objects. Maybe make it into a property tree?
        // assertEquals(response4.getBody().asString().substring(0,63),jsonPlayer2.toString().substring(0,63));

    }

   @Test
   public  void testPlayerDelete(){

   }



}
