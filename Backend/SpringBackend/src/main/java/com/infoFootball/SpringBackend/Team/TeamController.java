package com.infoFootball.SpringBackend.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    final private String success = "{\"message\":\"success\"}";
    final private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/teams")
    List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @PutMapping(path = "/teams/update/{teamName}")
    Team updateTeam(@RequestBody Team newTeam, @PathVariable String teamName){
        Team oldTeam = teamRepository.findByTeamName(teamName);
        if(oldTeam.equals(null)){
            return null;
        }
        teamRepository.deleteByTeamName(oldTeam.getTeamName());
        teamRepository.save(newTeam);
        return teamRepository.findByTeamName(newTeam.getTeamName());

    }

    @PostMapping(path ="/teams/new")
        public String newTeam(@RequestBody Team newTeam){
            teamRepository.save(newTeam);
            return "Success";
        }



}
