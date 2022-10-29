package com.infoFootball.SpringBackend.Concessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, String> {

    FoodItem findById(int Id);

    FoodItem deleteById(int Id);
}
