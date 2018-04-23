package com.sdcg3.sheltersearcher.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Acts as a data element
 */

public class DataElement {
    private final String _name;
    private final String _description;
    private final Location _location;

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
    }

    @Override
    public String toString() {
        return  _name + "\n" + _description;
    }

    /**
     *
     * @return name
     */
    private String getName() { return _name;}

    /**
     *
     * @return description
     */
    private String getDescription() {  return _description; }

    /**
     *
     * @return latitude
     */
    private double getLatitude() { return _location.getLatitude(); }

    /**
     *
     * @return longitude
     */
    private double getLongitude() { return _location.get_longitude(); }

    /**
     *
     * @return new LatLng object
     */
    public LatLng getLatitudeLongitude(){
        return new LatLng(getLatitude(), getLongitude());
    }

    /**
     *
     * @return MarkerOptions object with name, description, and new position
     */
    public MarkerOptions getMO(){
        MarkerOptions mo = new MarkerOptions();
        mo.position(getLatitudeLongitude());
        mo.title(getName());
        mo.snippet(getDescription());
        return mo;
    }

}
