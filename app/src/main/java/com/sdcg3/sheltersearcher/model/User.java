package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 */

public class User {
    public String name;
    public String pass;
    public String shelter;
    public String number;
    public User(String name, String pass){
        this.name = name;
        this.pass = pass;
    }
    public User(String name, String pass, String shelter, String number){
        this.name = name;
        this.pass = pass;
        this.shelter = shelter;
        this.number = number;
    }

    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }

}
