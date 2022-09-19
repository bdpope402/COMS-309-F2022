package com.infoFootball.SpringBackend;

public class UserID {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNum;

    /**
     * Creates a new userID object
     * Does not set email of user
     * @param firstName
     * @param lastName
     * @param password
     * @param phoneNum
     */
    public UserID(String firstName, String lastName, String password, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    /**
     * Sets the first name of a user
     * @param name new first name
     */
    public void setFirstName(String name) {
        this.firstName = name;
    }

    /**
     * Sets the last name of a user
     * @param name new last name
     */
    public void setLastName(String name) {
        this.lastName = name;
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
