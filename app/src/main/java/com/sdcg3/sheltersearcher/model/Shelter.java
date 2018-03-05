package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 */

public class Shelter {
    public String id;
    public String name;
    public String capacity;
    public String restrictions;
    public String notes;
    public String longi;
    public String lati;
    public String address;
    public String phone;

    public Shelter(String id, String name, String capacity, String restrictions, String longi, String lati, String address, String notes, String phone){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.restrictions = restrictions;
        this.notes = notes;
        this.longi = longi;
        this.lati = lati;
        this.address = address;
        this.phone = phone;
    }
    public String getName(){
        return name;
    }
}
