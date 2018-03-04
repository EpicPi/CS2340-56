package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 */

public class User {
    private String name;
    private String pass;

    public User(String name, String pass){
        this.name = name;
        this.pass = pass;
    }

    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }
    public String getUserName(){
        return name;
    }
}
