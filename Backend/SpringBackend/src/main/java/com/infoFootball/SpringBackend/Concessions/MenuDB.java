package com.infoFootball.SpringBackend.Concessions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MenuDB {

    @Id
    private int vendorKey; //Key found in vendor class

    @OneToOne
    private Menu menuID; //Key for menu

}
