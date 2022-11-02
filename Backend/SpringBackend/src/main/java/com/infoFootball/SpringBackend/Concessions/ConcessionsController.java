package com.infoFootball.SpringBackend.Concessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class ConcessionsController {

    //Repositories for tables
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    FoodItemRepository foodItemRepository;

    /*----------------------------VENDOR----------------------------*/

    /**
     * Gets a single vendor by name
     * @param vendorName name of vendor
     * @return JSON object of vendor
     */
    @GetMapping(path = "/vendor/{vendorName}")
    Vendor getOneVendor(@PathVariable String vendorName) {
        int vendorId = vendorRepository.findByName(vendorName).getVendorId();
        return vendorRepository.findByVendorId(vendorId);
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
        newVendor.setMenu(null);
        vendorRepository.save(newVendor);
        return "Success";
    }

    /**
     * Updates a vendor with a new vendor
     * @param newVendor JSON object of new vendor
     * @param oldVendorName String of old vendor name
     * @return New id of vendor
     */
    @Transactional
    @PutMapping(path = "/vendor/update/{vendorName}")
    Vendor updateVendor(@RequestBody Vendor newVendor, @PathVariable("vendorName") String oldVendorName) {
        Vendor oldVendor = vendorRepository.findByName(oldVendorName);
        if (oldVendor == null) {
            return null;
        }
        int vendorId = oldVendor.getVendorId();
        newVendor.setId(vendorId);
        vendorRepository.save(newVendor);
        return vendorRepository.findByVendorId(vendorId);
    }

    /**
     * Removes a vendor from the database
     * @param vendorName name of vendor to be removed
     * @return Success string if completed
     */
    @Transactional
    @DeleteMapping(path = "/vendor/delete/{vendorName}")
    String deleteVendor(@PathVariable String vendorName) {
        int vendorId = vendorRepository.findByName(vendorName).getVendorId();
        vendorRepository.deleteByVendorId(vendorId);
        return "Success";
    }

    /*----------------------------Food Menu----------------------------*/

    @GetMapping(path = "/menu/{id}")
    FoodMenu getOneMenu(@PathVariable int id) {
        return menuRepository.findByMenuId(id);
    }

    @GetMapping(path = "/menu/all")
    List<FoodMenu> getAllMenus() {
        return menuRepository.findAll();
    }

//    @PostMapping(path = "/menu/create/{vendorId}")
//    String createMenu(@RequestBody FoodMenu newMenu, @PathVariable int vendorId) {
//        newMenu.setVendor(vendorRepository.findByVendorId(vendorId));
//        menuRepository.save(newMenu);
//        return "Success";
//    }

    @PostMapping(path = "/menu/create")
    String createMenu2(@RequestParam int vendorId, @RequestParam String menuName, @RequestParam String menuDesc) {
        FoodMenu newMenu = new FoodMenu(menuName, menuDesc, null);
        newMenu.setVendor(vendorRepository.findByVendorId(vendorId));
        vendorRepository.findByVendorId(vendorId).setMenu(newMenu);
        menuRepository.save(newMenu);
        return "Success";
    }

    @PutMapping(path = "/menu/update/{id}")
    FoodMenu updateMenu(@RequestBody FoodMenu newMenu, @PathVariable int id) {
        FoodMenu oldMenu = menuRepository.findByMenuId(id);
        if (oldMenu == null) {
            return null;
        }
        newMenu.setMenuId(id);
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
