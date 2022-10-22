package com.infoFootball.SpringBackend.Player;

import com.infoFootball.SpringBackend.Player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRespository extends JpaRepository<Player, String> {

    Player findByID(int ID);

    Player deleteByID(int ID );

    List<Player> findByPlayerNum(String number);
}

