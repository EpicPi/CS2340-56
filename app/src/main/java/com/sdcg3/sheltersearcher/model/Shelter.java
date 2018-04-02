package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 *
 */

public class Shelter {
    private String id;
    public String name;
    public int capacity;
    public String restrictions;
    public String notes;
    public String longitude;
    public String latitude;
    public String address;
    public String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getClaimed() {
        return claimed;
    }

    public void setClaimed(int claimed) {
        this.claimed = claimed;
    }

    public int claimed;

    public Shelter(String id, String name, String capacity, String restrictions, String longitude,
                   String latitude, String address, String notes, String phone, String claimed) {
        this.id = id;
        this.name = name;
        this.capacity = Integer.parseInt(capacity);
        this.restrictions = restrictions;
        this.notes = notes;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.phone = phone;
        this.claimed = Integer.parseInt(claimed);
    }

    public String getName() {
        return name;
    }

    public String[] getWritable() {
        return new String[]{id, name, capacity + "", restrictions, longitude, latitude,
                address, notes, phone, claimed + ""};
    }
}
