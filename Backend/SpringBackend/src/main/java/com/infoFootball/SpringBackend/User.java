package com.infoFootball.SpringBackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String name;
    private String password;
    private String email;
    private String phoneNum;

    /**
     * Creates a new userID object
     * Does not set email of user
     * @param name
     * @param email
     * @param password
     * @param phoneNum
     */
    public User(String name, String email, String password, String phoneNum) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    /**
     * Sets the first name of a user
     * @param name new first name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the password of a user
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the email of a user
     * @param email email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the phone number of a user
     * @param phoneNum new phone number
     */
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

}