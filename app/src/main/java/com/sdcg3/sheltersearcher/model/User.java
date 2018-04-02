package com.sdcg3.sheltersearcher.model;

import java.util.Objects;

/**
 * Created by pi on 3/4/18.
 *
 */

public class User {
    public final String name;
    private final String pass;
    public String shelter;
    public int number;
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
        if(Objects.equals(number, "") || (number == null))
            this.number = 0;
        else
            this.number = Integer.parseInt(number);
    }

    public String[] getWritable(){
        return new String[]{name,pass,shelter,number+""};
    }
    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }

}
