package com.infoFootball.SpringBackend.Player;

import com.infoFootball.SpringBackend.Player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRespository extends JpaRepository<Player, String> {

    Player findByID(String name);

    Player deleteByName(String username);
}

