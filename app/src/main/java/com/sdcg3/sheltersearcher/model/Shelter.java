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

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     *
//     * @return String id
//     */
//    public String getId() {
//        return id;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     * sets id
//     * @param id id
//     */
//    public void setId(String id) {
//        this.id = id;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     * name
//     * @param name name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

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

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     *
//     * @param restrictions restrictions
//     */
//    public void setRestrictions(String restrictions) {
//        this.restrictions = restrictions;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

    /**
     *
     * @return notes
     */
    public CharSequence getNotes() {
        return notes;
    }

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     *
//     * @param notes notes
//     */
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

    /**
     *
     * @return longitude
     */
    public CharSequence getLongitude() {
        return longitude;
    }

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     *
//     * @param longitude longitude
//     */
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

    /**
     *
     * @return latitude
     */
    public CharSequence getLatitude() {
        return latitude;
    }

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     *
//     * @param latitude latitude
//     */
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

    /**
     *
     * @return address
     */
    public CharSequence getAddress() {
        return address;
    }

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     *
//     * @param address address
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

    /**
     *
     * @return phone
     */
    public CharSequence getPhone() {
        return phone;
    }

// --Commented out by Inspection START (4/4/18 10:03 PM):
//    /**
//     *
//     * @param phone phone
//     */
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
// --Commented out by Inspection STOP (4/4/18 10:03 PM)

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

    private int claimed;

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

    /**
     *
     * @return a desc
     */
    private String getDesc(){
        return "Phone Number: " + phone + "\n" + "Address:  " +
                address + "\n" + "Information:  " + notes;
    }

    /**
     *
     * @return a data element
     */
    public DataElement getEl(){
        return new DataElement(name, getDesc(),
                new Location(Double.parseDouble(latitude),
                        Double.parseDouble(longitude)));
    }

    /**
     *
     * @param amount removes this from available
     */
    public void removeAmount(int amount){
        capacity -= amount;
        claimed += amount;
    }
}
