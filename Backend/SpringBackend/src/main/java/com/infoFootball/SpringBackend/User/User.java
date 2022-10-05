package com.infoFootball.SpringBackend.User;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class is the base for creating a user. Through it, you can set name
 * email, phone number, and password, which then can be saved into the database
 */
@Entity
public class User {

    /*
    * @ID marks the below field as the primary key for the table
    * The @GeneratedValue generates a value if not present (Will start at 1, 2 etc.)
     */
    @Id
    private String name;
    private String password;
    private String email;
    private String phoneNum;

    public User() {
        this.name = null;
        this.email = null;
        this.password = null;
        this.phoneNum = null;
    }

    /**
     * Creates a new userID object
     * Does not set email of user
     * @param name User's name
     * @param email User's email
     * @param password User's password
     * @param phoneNum User's phone number
     */
    public User(String name, String email, String password, String phoneNum) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    // SET FUNCTIONS //

    /**
     * Sets the first name of a user
     * @param name new first name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the email of a user
     * @param email email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the password of a user
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the phone number of a user
     * @param phoneNum new phone number
     */
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    //GET FUNCTIONS //

    /**
     * Returns the value of the private name variable
     * @return string name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the value of the private email variable
     * @return string email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns a string containing the password
     * @return string password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the string of phone number
     * @return string phone numbers
     */
    public String getPhoneNum() {
        return this.phoneNum;
    }

}