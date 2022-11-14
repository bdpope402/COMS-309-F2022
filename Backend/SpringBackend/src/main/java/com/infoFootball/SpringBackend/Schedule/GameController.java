package com.infoFootball.SpringBackend.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infoFootball.SpringBackend.Team.*;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameRepository gameRespository;

    final private String success = "{\"message\":\"success\"}";
    final private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/games")
    List<Game> getAllGames(){
        return gameRespository.findAll();
    }


}
