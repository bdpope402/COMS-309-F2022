package com.infoFootball.SpringBackend;

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
public class UserTests {

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
    public void testCreateUser() throws Exception {
        //Creating user JSON object
        JSONObject jsonUser = new JSONObject();
        jsonUser.put("username", "testUser");
        jsonUser.put("password","testPassword");
        jsonUser.put("email","testEmail@email");
        jsonUser.put("phoneNum","123456789");
        jsonUser.put("permLv","Admin");

        User newUser = new User("testUser", "testPassword", "testEmail@email", "123456789", "Admin");

        //Create a post request
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonUser.toString()) //Send in json USER
                .when().request("POST", "/login/register");

        //Checking status code
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        //Check that it returns a success
        String returnString = response.getBody().asString();
        assertEquals("Success", returnString);
    }


}
