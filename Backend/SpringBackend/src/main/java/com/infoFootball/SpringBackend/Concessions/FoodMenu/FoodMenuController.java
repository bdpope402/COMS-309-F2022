package com.infoFootball.SpringBackend.Concessions.FoodMenu;

import com.infoFootball.SpringBackend.Concessions.Vendor.Vendor;
import com.infoFootball.SpringBackend.Concessions.Vendor.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodMenuController {


    @Autowired
    MenuRepository menuRepository;
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    FoodMenuService foodMenuService;

    @GetMapping(path = "/menu/{id}")
    FoodMenu getOneMenu(@PathVariable int id) {
        return menuRepository.findByMenuId(id);
    }

    @GetMapping(path = "/menu/all")
    List<FoodMenu> getAllMenus() {
        return menuRepository.findAll();
    }

    @PostMapping(path = "/menu/create")
    String createMenu(@RequestParam String menuName, @RequestParam String menuDesc, @RequestParam int vendorId) {
        Vendor vendor = vendorRepository.findByVendorId(vendorId);
        return foodMenuService.createNewMenu(menuName, menuDesc, vendor);
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
}
