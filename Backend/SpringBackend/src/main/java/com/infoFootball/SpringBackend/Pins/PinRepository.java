package com.infoFootball.SpringBackend.Pins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<Pin, String> {

    List<Pin> findByUsername(String username);

    Pin findByID(Integer IDNum);

    Pin deleteByID(Integer IDNum);
}
