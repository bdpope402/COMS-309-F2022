package com.infoFootball.SpringBackend.Team;
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

    private String imgPath;

    public Team(){
        this.teamName = null;
        this.teamLocation = null;
        this.wins = null;
        this.losses = null;
        this.rank = null;
        this.imgPath = null;
    }

    public Team(String teamName, String teamLocation, Integer wins, Integer losses, String imgPath){
        this.teamName = teamName;
        this.teamLocation = teamLocation;
        this.wins = wins;
        this.losses = losses;
        this.imgPath = imgPath;
        this.rank = null;
    }

    public Team(String teamName, String teamLocation, Integer wins, Integer losses, String imgPath, Integer rank){
        this.teamName = teamName;
        this.teamLocation = teamLocation;
        this.wins = wins;
        this.losses = losses;
        this.imgPath = imgPath;
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

    public String getImgPath(){ return imgPath; }

    public void setImgPath(String imgPath){ this.imgPath = imgPath;}

}
