package com.infoFootball.SpringBackend.Concessions;

import javax.persistence.*;
import java.util.List;

@Entity
public class FoodMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int MenuId; //Id for menu
    private String menuName; //Name of menu
    private String menuDesc; //Description of menu/season

    @OneToOne
    private Vendor vendor;

    @OneToMany
    private List<FoodItem> items; //List of items in menu

    public FoodMenu() {
        this.MenuId = -1;
        this.menuName = null;
        this.menuDesc = null;
        this.vendor = null;
        this.items = null;
    }

    public FoodMenu(String name, String desc, List<FoodItem> items) {
        this.menuName = name;
        this.menuDesc = desc;
        this.items = items;
    }

    //Getters and setters

    public int getMenuId() {
        return MenuId;
    }

    public void setMenuId(int menuId) {
        MenuId = menuId;
    }

    public String getName() {
        return menuName;
    }

    public void setName(String name) {
        this.menuName = name;
    }

    public String getDesc() {
        return menuDesc;
    }

    public void setDesc(String desc) {
        this.menuDesc = desc;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }
}
