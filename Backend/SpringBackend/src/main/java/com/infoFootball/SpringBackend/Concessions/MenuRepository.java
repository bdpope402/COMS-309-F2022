package com.infoFootball.SpringBackend.Concessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<FoodMenu, String> {

    //FoodMenu findByName(String name);
    FoodMenu findByMenuId(int MenuId);

    //FoodMenu deleteByName(String name);
    FoodMenu deleteByMenuId(int MenuId);
}
