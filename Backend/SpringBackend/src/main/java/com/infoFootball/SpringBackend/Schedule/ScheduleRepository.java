package com.infoFootball.SpringBackend.Schedule;

import com.infoFootball.SpringBackend.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScheduleRepository extends JpaRepository<Game, String> {

        User findByGame(Game game);

        User deleteByGame(Game game);
}

