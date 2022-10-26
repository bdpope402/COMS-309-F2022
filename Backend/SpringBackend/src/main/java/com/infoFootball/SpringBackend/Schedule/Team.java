package com.infoFootball.SpringBackend.Schedule;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    private String teamName;

    private String teamLocation;

    private Integer wins;

    private Integer rank;

    private Integer losses;

    public Team(){
        this.teamName = null;
        this.teamLocation = null;
        this.wins = null;
        this.losses = null;
        this.rank = null;
    }

    public Team(String teamName, String teamLocation, Integer wins, Integer losses){
        this.teamName = teamName;
        this.teamLocation = teamLocation;
        this.wins = wins;
        this.losses = losses;
        this.rank = null;
    }

    public Team(String teamName, String teamLocation, Integer wins, Integer losses, Integer rank){
        this.teamName = teamName;
        this.teamLocation = teamLocation;
        this.wins = wins;
        this.losses = losses;
        this.rank = rank;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLocation() {
        return teamLocation;
    }

    public void setTeamLocation(String teamLocation) {
        this.teamLocation = teamLocation;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

}
