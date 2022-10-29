package com.infoFootball.SpringBackend.Concessions;

import javax.persistence.*;

@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int FoodId;

    @ManyToOne
    private FoodMenu menu;

    private String name;
    private long price;
    private int cal;
    private int stock;

    public FoodItem() {
    }

    public FoodItem(FoodMenu menuId, String name, long price, int cal, int stock) {
        this.menu = menuId;
        this.name = name;
        this.price = price;
        this.cal = cal;
        this.stock = stock;
    }

}
