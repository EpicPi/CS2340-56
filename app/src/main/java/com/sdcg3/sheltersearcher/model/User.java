package com.sdcg3.sheltersearcher.model;

import java.util.List;


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
        this.shelter = "";
        this.number = 0;
    }
    public User(String name, String pass, String shelter, String number){
        this.name = name;
        this.pass = pass;
        this.shelter = shelter;
        if (number =="")
            this.number = 0;
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            this.number = 0;
        } catch (NullPointerException e) {
            this.number = 0;
        }

    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }



    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }
    public String getShelter() {
        return shelter;
    }

    public int getNumber() {
        return number;
    }

    public boolean equals(User o) {
        if (this == o) {
            return true;
        }

        if (this.name.equals(o.name)) {
            if (this.pass.equals(o.pass)) {
                if (this.shelter.equals(o.shelter)) {
                    if (this.number == o.number) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String[] getWritable(){
        return new String[]{name,pass,shelter,number+""};
    }
    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }

    public static User findByNumber(int num, List<User> users) {
        if (users == null) {
            return null;
        }

        for (User u: users) {
            if (u.number == num) {
                return u;
            }
        }

        return null;
    }
}
