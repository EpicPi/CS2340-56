package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 */

public class Shelter {
    private String id;
    private String name;
    private String capacity;
    private String restrictions;
    private String gender;
    private String longi;
    private String lati;
    private String address;
    private String phone;

    public Shelter(String id, String name, String capacity, String restrictions, String gender, String longi, String lati, String address, String phone){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.gender = gender;
        this.longi = longi;
        this.lati = lati;
        this.address = address;
        this.phone = phone;
    }
    public String getName(){
        return name;
    }
}
