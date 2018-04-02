package com.sdcg3.sheltersearcher.model;

import java.util.Objects;

/**
 * Created by pi on 3/4/18.
 *
 */

public class User {
    private final String name;
    private final String pass;
    private String shelter;
    private int number;

    public String getName() {
        return name;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User(String name, String pass){
        this.name = name;
        this.pass = pass;
        this.shelter = "";

        this.number = 0;
    }
    public User(String name, String pass, String shelter, String number){
        this.name = name;
        this.pass = pass;
        this.shelter = shelter;
        if(Objects.equals(number, "") || (number == null)) {
            this.number = 0;
        } else {
            this.number = Integer.parseInt(number);
        }
    }

    public String[] getWritable(){
        return new String[]{name,pass,shelter,number+""};
    }
    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }

}
