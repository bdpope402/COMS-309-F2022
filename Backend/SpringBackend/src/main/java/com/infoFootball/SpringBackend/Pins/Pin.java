package com.infoFootball.SpringBackend.Pins;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pin {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ID;

    private String username;

    private Long latitude;
    private Long longitude;

    private String pinName;


    public Pin() {
        this.username = null;
        this.latitude = null;
        this.longitude = null;
        this.pinName = null;
    }

    public Pin(String username, Long latitude, Long longitude, String pinName){
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pinName = pinName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getPinName() {
        return pinName;
    }

    public void setPinName(String pinName) {
        this.pinName = pinName;
    }
    public void setIDNum(int IDNum) {
        this.ID = IDNum;
    }

    public int getIDNum() {
        return ID;
    }
}

