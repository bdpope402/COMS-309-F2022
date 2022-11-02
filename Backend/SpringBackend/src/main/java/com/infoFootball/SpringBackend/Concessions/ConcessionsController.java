package com.infoFootball.SpringBackend.Concessions;

import com.infoFootball.SpringBackend.Concessions.FoodItem.FoodItem;
import com.infoFootball.SpringBackend.Concessions.FoodItem.FoodItemRepository;
import com.infoFootball.SpringBackend.Concessions.FoodMenu.FoodMenu;
import com.infoFootball.SpringBackend.Concessions.FoodMenu.MenuRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcessionsController {

    //Repositories for tables


    FoodItemRepository foodItemRepository;

    /*----------------------------VENDOR----------------------------*/



    /*----------------------------Food Menu----------------------------*/



    /*----------------------------Food Item----------------------------*/

    @GetMapping(path = "/item/{id}")
    FoodItem getItem(@PathVariable int id) {
        return foodItemRepository.findByFoodId(id);
    }

    @PostMapping(path = "/item/create")
    String createItem(@RequestBody FoodItem newItem) {
        foodItemRepository.save(newItem);
        return "Success";
    }

    @PutMapping(path = "/item/update/{id}")
    FoodItem updateItem(@RequestBody FoodItem newItem, @PathVariable int id) {
        FoodItem oldItem = foodItemRepository.findByFoodId(id);
        if (oldItem == null) {
            return null;
        }
        foodItemRepository.save(newItem);
        return foodItemRepository.findByFoodId(id);
    }

    @DeleteMapping(path = "/item/delete/{id}")
    String delete(@PathVariable int id) {
        foodItemRepository.deleteByFoodId(id);
        return "Success";
    }

}
