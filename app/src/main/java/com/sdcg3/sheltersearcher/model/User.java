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

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return shelter name
     */
    public String getShelter() {
        return shelter;
    }

    /**
     *
     * @param shelter shelter name
     */
    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    /**
     *
     * @return amount of beds
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @param number amount of beds
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * constructor
     * @param name name
     * @param pass pass
     */
    public User(String name, String pass){
        this.name = name;
        this.pass = pass;
        this.shelter = "";

        this.number = 0;
    }

    /**
     *
     * @param name name
     * @param pass pass
     * @param shelter shelter
     * @param number number
     */
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

    /**
     *
     * @return Writable
     */
    public String[] getWritable(){
        return new String[]{name,pass,shelter,number+""};
    }

    /**
     *
     * @param pass pass
     * @return Writable
     */
    public boolean checkPass(String pass){
        return this.pass.equals(pass);
    }

    /**
     * releases beds
     * @return the old number of beds
     */
    public int releaseBeds(){
        int x = getNumber();
        setNumber(0);
        setShelter("");
        return x;
    }

}
