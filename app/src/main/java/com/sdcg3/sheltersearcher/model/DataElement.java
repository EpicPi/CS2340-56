package com.sdcg3.sheltersearcher.model;

/**
 * Created by aballari on 3/27/18.
 */

public class DataElement {
    private static int Next_ID = 1000;
    private int _id;
    private String _name;
    private String _description;
    private Location _location;

    /**
     * Create new element
     * @param name   the name of the element
     * @param desc   a textual description
     * @param location  the location of the element
     */
    public DataElement(String name, String desc, Location location) {
        _name = name;
        _description = desc;
        _location = location;
        _id = Next_ID++;
    }

    @Override
    public String toString() {
        return  _name + "\n" + _description;
    }

    /*
     Getters for the data elements
     */
    public String getName() { return _name;}
    public String getDescription() {  return _description; }

    public double getLatitude() { return _location.getLatitude(); }
    public double getLongitude() { return _location.get_longitude(); }

}
