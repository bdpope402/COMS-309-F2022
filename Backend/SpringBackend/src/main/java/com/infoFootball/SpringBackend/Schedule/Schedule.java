package com.infoFootball.SpringBackend.Schedule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * @author bdpope
 * This is the schedule object. It has
 */
public class Schedule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ID;

    private List<Game> gameList;

    public Schedule(){
        gameList = null;
    }

    public Schedule(List<Game> gameList){
        this.gameList.addAll(gameList);
    }

    public void addGame(Game newGame){
        this.gameList.add(newGame);
    }

    public void removeGame(Game badGame){
        gameList.remove(badGame);
    }

    public List<Game> getSchedule(){
        return gameList;
    }
}
