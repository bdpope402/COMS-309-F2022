package com.infoFootball.SpringBackend.Team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    Team findByTeamName(String name);

    void deleteByTeamName(String name);
}
