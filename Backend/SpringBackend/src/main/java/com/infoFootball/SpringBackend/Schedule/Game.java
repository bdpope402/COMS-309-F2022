package com.infoFootball.SpringBackend.Schedule;


import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer gameID;
    @ManyToOne
    @JoinColumn(name = "home_team_team_name")
    private Team homeTeam;
    @ManyToOne
    @JoinColumn(name = "away_team_team_name")
    private Team awayTeam;

    private String time;

    @ManyToOne
    @JoinColumn(name = "game_controller_ID")
    private GameController gameController;

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public Game(){
        this.homeTeam = null;
        this.awayTeam = null;
        this.time = null;
    }

    public  Game(Team homeTeam, Team awayTeam, String time){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.time = time;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation(){
       return homeTeam.getTeamLocation();
    }

    public Integer getHomeRank() {
        return homeTeam.getRank();
    }

    public Integer getAwayRank() {
        return awayTeam.getRank();
    }


}
