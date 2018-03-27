package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 *
 */

public class User {
    public String name;
    private String pass;
    public String shelter;
    public int number;
    public User(String name, String pass){
        this.name = name;
        this.pass = pass;
    }
    public User(String name, String pass, String shelter, String number){
        this.name = name;
        this.pass = pass;
        this.shelter = shelter;
        this.number = Integer.parseInt(number);
    }

    public String[] getWritable(){
        return new String[]{name,pass,shelter,number+""};
    }
    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }

}
