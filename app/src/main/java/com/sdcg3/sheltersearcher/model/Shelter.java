package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 */

public class Shelter {
    private String name;
    private int capacity;
    private GENDER gender;
    private double longi;
    private double lati;
    private String address;
    private String phone;

    public Shelter(String name, int capacity, GENDER gender, double longi, double lati, String address, String phone){
        this.name = name;
        this.capacity = capacity;
        this.gender = gender;
        this.longi = longi;
        this.lati = lati;
        this.address = address;
        this.phone = phone;c
    }
}
