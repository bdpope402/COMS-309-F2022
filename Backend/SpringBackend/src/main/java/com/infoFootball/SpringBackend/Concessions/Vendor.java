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


}
