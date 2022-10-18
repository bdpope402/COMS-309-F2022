package com.infoFootball.SpringBackend.Concessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

    Menu findByName(String name);
    //Menu findById(int Id);

    Menu deleteByName(String name);
    //Menu deleteById(int Id);
}
