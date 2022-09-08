package com.springboot.app.user;

import java.util.Random;

class User {

    private int id;
    private int yearsWorked;
    private String name;
    private String role;

    User(String name, String role){
        this.name = name;
        this.role = role;
        Random rand = new Random();
        this.id = Math.abs(rand.nextInt());
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getYearsWorked() {
        return yearsWorked;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeRole(String role) {
        this.role = role;
    }

    public void updateYearsWorked() {
        yearsWorked += 1;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + this.name + ", role=" + this.role + ", yearsWorked=" + this.yearsWorked + ", id=" + this.id;
    }

}
