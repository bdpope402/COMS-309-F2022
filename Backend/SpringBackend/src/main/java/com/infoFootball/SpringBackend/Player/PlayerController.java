package com.infoFootball.SpringBackend.Player;
import java.util.List;

import com.infoFootball.SpringBackend.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @todo update all of this to player junk
 * This class is for controlling player entry and all the critical
 * bits for adding, updating, getting, and deleting players
 */
@RestController
public class PlayerController {
    @Autowired
    PlayerRespository playerRespository;

    final private String success = "{\"message\":\"success\"}";
    final private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/players")
    List<Player> getAllPlayers(){
        return playerRespository.findAll();
    }

    /**
     * Returns
     * @param num playername of player
     * @return player related to playername
     */
    @GetMapping(path = "/players/{playername}")
    List<Player> getplayersByNumber(@PathVariable String num){
        return playerRespository.findByPlayerNum(num);
    }

    @PostMapping("/players/new")
    public String newPlayer(@RequestBody Player newPlayer) {
        playerRespository.save(newPlayer);
        return "Success";
    }

    /**
     * Updates player using the unique ID and creates a new
     * @param ID uniquie ID of player
     * @param request the updated player info
     * @return updated player, null if ID doesn't have a player with it
     */
    @PutMapping("/players/{ID}")
    Player updateplayer(@PathVariable int ID, @RequestBody Player request){
        Player player = playerRespository.findByID(ID);
        if(player == null)
            return null;
        playerRespository.save(request);
        return playerRespository.findByID(ID);
    }

    /**
     * Deletes a player by ID
     * @param ID ID of player to be deleted
     * @return if player was successfully deleted
     */
    @DeleteMapping("/players/{playername}")
    String deleteplayer(@PathVariable int ID){
        playerRespository.deleteByID(ID);
        return success;
    }
}
