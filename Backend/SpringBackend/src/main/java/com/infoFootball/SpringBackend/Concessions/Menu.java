package com.infoFootball.SpringBackend.Concessions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private boolean stock; //True for in stock - false for out of stock
    private int stockNum; //Num for stock left
    private int price;

    @ManyToOne
    private Vendor vendor; //To correlate to a vendor

}
