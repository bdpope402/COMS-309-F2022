package com.infoFootball.SpringBackend.Concessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcessionsController {

    //Repositories for tables
    @Autowired
    VendorRepository vendorRepository;
    MenuRepository menuRepository;
    FoodItemRepository foodItemRepository;

    /*----------------------------VENDOR----------------------------*/

    /**
     * Gets a single vendor by name
     * @param vendorName name of vendor
     * @return JSON object of vendor
     */
    @GetMapping(path = "/vendors/{vendorName}")
    Vendor getOneVendor(@PathVariable String vendorName) {
        return vendorRepository.findByName(vendorName);
    }

    /**
     * Gets all vendors
     * @return List of vendors
     */
    @GetMapping(path = "/vendor/all")
    List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    /**
     * Creates and saves a new vendor to the database
     * @param newVendor JSON vendor object
     * @return Success string if completed
     */
    @PostMapping(path = "/vendor/register")
    String createVendor(@RequestBody Vendor newVendor) {
        vendorRepository.save(newVendor);
        return "Success";
    }

    /**
     * Updates a vendor with a new vendor
     * @param newVendor JSON object of new vendor
     * @param oldVendorName String of old vendor name
     * @return JSON of updated vendor object
     */
    @PutMapping(path = "/vendor/update/{vendorName}")
    Vendor updateVendor(@RequestBody Vendor newVendor, @PathVariable String oldVendorName) {
        Vendor oldVendor = vendorRepository.findByName(oldVendorName);
        if (oldVendor == null) {
            return null;
        }
        vendorRepository.save(newVendor);
        return vendorRepository.findByName(oldVendorName);
    }

    /**
     * Removes a vendor from the database
     * @param vendorName name of vendor to be removed
     * @return Success string if completed
     */
    @DeleteMapping(path = "/vendor/delete/{vendorName}")
    String deleteVendor(@PathVariable String vendorName) {
        vendorRepository.deleteByName(vendorName);
        return "Success";
    }

    /*----------------------------Food Menu----------------------------*/

    @GetMapping(path = "/menu/{id}")
    FoodMenu getOneMenu(@PathVariable int id) {
        return menuRepository.findById(id);
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
        FoodMenu oldMenu = menuRepository.findById(id);
        if (oldMenu == null) {
            return null;
        }
        menuRepository.save(newMenu);
        return menuRepository.findById(id);
    }

    @DeleteMapping(path = "/menu/delete/{id}")
    String deleteMenu(@PathVariable int id) {
        menuRepository.deleteById(id);
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
