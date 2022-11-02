package com.infoFootball.SpringBackend.Concessions.FoodMenu;

import com.infoFootball.SpringBackend.Concessions.Vendor.Vendor;
import org.springframework.beans.factory.annotation.Autowired;


public class FoodMenuService {

    @Autowired
    MenuRepository menuRepository;

    public String createNewMenu(String menuName, String menuDesc, Vendor vendor) {
        FoodMenu newMenu = new FoodMenu(menuName, menuDesc);
        newMenu.setVendor(vendor);

        try {
            menuRepository.save(newMenu);
        } catch (Exception e) {
            return "Failed";
        }

        return "Success";
    }

}
