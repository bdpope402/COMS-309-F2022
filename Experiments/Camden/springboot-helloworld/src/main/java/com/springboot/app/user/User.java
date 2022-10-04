package com.springboot.app.user;

import java.util.Random;

class User {

    private int id;
    private int yearsWorked;
    private String name;
    private String role;

    private String team;

    User(String name, String role, String Team){
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

    public void updateYearsOnPlatform() {
        yearsWorked += 1;
    }

    public String getTeam() {return this.team;}
    public string setTeam(String s) { this.team = s; }

    @Override
    public String toString() {
        return "User{" + "name=" + this.name + ", role=" + this.role + ", yearsWorked=" + this.yearsWorked + ", id=" + this.id;
    }

}
