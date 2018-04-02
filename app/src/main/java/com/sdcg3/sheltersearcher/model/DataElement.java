package com.sdcg3.sheltersearcher.model;

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
    public String getName() { return _name;}

    /**
     *
     * @return description
     */
    public String getDescription() {  return _description; }

    /**
     *
     * @return latitude
     */
    public double getLatitude() { return _location.getLatitude(); }

    /**
     *
     * @return longitude
     */
    public double getLongitude() { return _location.get_longitude(); }

}
