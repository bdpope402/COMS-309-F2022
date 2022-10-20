package com.infoFootball.SpringBackend.Concessions;

import javax.persistence.*;

/**
 * This class is the base for creating a Vendor.
 * Lets you set menu, and what level of maintainer you need to edit
 */
@Entity
public class Vendor {

    //@ID marks the below field as the primary key for the table
    //@GeneratedValue will auto generate a num (1, 2, 3...)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private boolean status; //True for open - false for closed
    private String location;

    @ManyToOne
    private Menu menu;

    /**
     * Creates a null Vendor object
     */
    public Vendor() {
        this.id = -1;
        this.name = null;
        this.status = false;
        this.location = null;
        this.menu = null;
    }

    /**
     * Creates a new vendor object
     * @param id vendor id num (int)
     * @param name vendor name (string)
     * @param status vendor status (open closed, true false) (bool)
     * @param location vendor location (string)
     * @param menu vendor menu (table)
     */
    public Vendor(int id, String name, boolean status, String location, Menu menu) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
        this.menu = menu;
    }


    // SET FUNCTIONS //

    /**
     * Sets ID of vendor
     * @param id vendor ID (int)
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets name of vendor
     * @param name vendor name (string)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets open/closed status of vendor (true open, false closed)
     * @param status vendor status (bool)
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Sets location of vendor
     * @param location vendor location (string)
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the menu of the vendor
     * @param menu vendor menu (table ID)
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    // GET FUNCTIONS //

    /**
     * Gets vendor ID
     * @return vendor ID (int)
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets vendor name
     * @return vendor name (string)
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets vendor status (true open, false closed)
     * @return vendor status (bool)
     */
    public boolean getStatus() {
        return this.status;
    }

    /**
     * Gets vendor location
     * @return vendor location (string)
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Gets vendor menu ID
     * @return vendor menu ID
     */
    public Menu getMenu() {
        return this.menu;
    }

}
