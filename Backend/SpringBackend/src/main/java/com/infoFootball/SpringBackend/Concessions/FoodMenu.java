package com.infoFootball.SpringBackend.Concessions;

import javax.persistence.*;
import java.util.List;

@Entity
public class FoodMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int MenuId; //Id for menu

    private String name; //Name of menu
    private String desc; //Description of menu/season

    @OneToOne
    private Vendor vendor;

    @OneToMany
    @JoinColumn
    private List<FoodItem> items; //List of items in menu

    public FoodMenu() {
    }

    public FoodMenu(String name, String desc, List<FoodItem> items) {
        this.name = name;
        this.desc = desc;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
