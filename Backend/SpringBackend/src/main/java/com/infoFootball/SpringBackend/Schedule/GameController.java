package com.infoFootball.SpringBackend.Schedule;

import com.infoFootball.SpringBackend.Player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    List<Game> getAllGames() {
        return gameRespository.findAll();
    }

    @GetMapping(path = "/games/get")
    Game getGameByAwayTeam(@RequestBody Team awayTeam) {
        return gameRespository.findByAwayTeam(awayTeam);
    }

    @PutMapping(path = "/games/update")
    Game updateGame(@RequestBody Team awayTeam, @RequestBody Game newGame) {
        Game game = gameRespository.findByAwayTeam(awayTeam);
        if (game.equals(null)) {
            return null;
        }
        gameRespository.deleteByAwayTeam(awayTeam);
        gameRespository.save(newGame);
        return gameRespository.findByAwayTeam(newGame.getAwayTeam());
    }

    @PostMapping(path = "/games/new")
    public String newGame(@RequestBody Game newGame) {
        gameRespository.save(newGame);
        return "Success";
    }
}


