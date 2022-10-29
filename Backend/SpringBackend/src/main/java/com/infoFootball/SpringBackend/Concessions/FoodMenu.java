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
}
