package com.infoFootball.SpringBackend.Schedule;

import com.infoFootball.SpringBackend.Team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GameRepository extends JpaRepository<Game, String> {

        Game findByTime(String time);

        Game findByAwayTeam(Team awayTeam);

        Game deleteByTime(String time);

        Game deleteByAwayTeam(Team awayTeam);
}

