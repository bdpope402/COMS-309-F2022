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

    MenuRepository menuRepository;
    FoodItemRepository foodItemRepository;

    /*----------------------------VENDOR----------------------------*/



    /*----------------------------Food Menu----------------------------*/

    @GetMapping(path = "/menu/{id}")
    FoodMenu getOneMenu(@PathVariable int id) {
        return menuRepository.findByMenuId(id);
    }

    @GetMapping(path = "/menu/all")
    List<FoodMenu> getAllMenus() {
        return menuRepository.findAll();
    }

    @PostMapping(path = "/menu/create")
    String createMenu(@RequestBody FoodMenu newMenu) {
        menuRepository.save(newMenu);
        return "Success";
    }

    @PutMapping(path = "/menu/update/{id}")
    FoodMenu updateMenu(@RequestBody FoodMenu newMenu, @PathVariable int id) {
        FoodMenu oldMenu = menuRepository.findByMenuId(id);
        if (oldMenu == null) {
            return null;
        }
        menuRepository.save(newMenu);
        return menuRepository.findByMenuId(id);
    }

    @DeleteMapping(path = "/menu/delete/{id}")
    String deleteMenu(@PathVariable int id) {
        menuRepository.deleteByMenuId(id);
        return "Success";
    }

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
