package com.sdcg3.sheltersearcher.model;

/**
 * Created by pi on 3/4/18.
 *
 */

public class Shelter {
    private String id;
    private String name;
    private int capacity;
    private String restrictions;
    private String notes;
    private String longitude;
    private String latitude;
    private String address;
    private String phone;

    /**
     *
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * sets id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     *
     * @param capacity capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     *
     * @return restrictions
     */
    public String getRestrictions() {
        return restrictions;
    }

    /**
     *
     * @param restrictions restrictions
     */
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    /**
     *
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return claimed
     */
    public int getClaimed() {
        return claimed;
    }

    /**
     *
     * @param claimed claimed
     */
    public void setClaimed(int claimed) {
        this.claimed = claimed;
    }

    public int claimed;

    /**
     *
     * @param id id
     * @param name name
     * @param capacity capacity
     * @param restrictions restrictions
     * @param longitude longitude
     * @param latitude latitude
     * @param address address
     * @param notes notes
     * @param phone phone
     * @param claimed claimed
     */
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

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     *@return Writable
     */
    public String[] getWritable() {
        return new String[]{id, name, capacity + "", restrictions, longitude, latitude,
                address, notes, phone, claimed + ""};
    }
}
