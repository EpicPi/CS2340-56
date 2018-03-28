package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 *
 */

public class Shelter {
    public String id;
    public String name;
    public int capacity;
    public String restrictions;
    public String notes;
    public String longi;
    public String lati;
    public String address;
    public String phone;
    public int claimed;

    public Shelter(String id, String name, String capacity, String restrictions, String longi, String lati, String address, String notes, String phone, String claimed){
        this.id = id;
        this.name = name;
        this.capacity = Integer.parseInt(capacity);
        this.restrictions = restrictions;
        this.notes = notes;
        this.longi = longi;
        this.lati = lati;
        this.address = address;
        this.phone = phone;
        this.claimed = Integer.parseInt(claimed);
    }
    public String getName(){
        return name;
    }
    public String[] getWritable(){
        return new String[]{id,name,capacity+"",restrictions, longi,lati,address,notes,phone,claimed+""};
    }
}
