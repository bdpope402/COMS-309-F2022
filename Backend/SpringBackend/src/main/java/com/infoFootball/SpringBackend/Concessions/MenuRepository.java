package com.infoFootball.SpringBackend.Concessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<FoodMenu, String> {

    FoodMenu findByName(String name);
    //Menu findById(int Id);

    FoodMenu deleteByName(String name);
    //Menu deleteById(int Id);
}
