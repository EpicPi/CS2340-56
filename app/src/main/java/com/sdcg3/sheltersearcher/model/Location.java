package com.sdcg3.sheltersearcher.model;

/**
 * Created by aballari on 3/27/18.
 */

public class Location {
    private double _latitude;
    private double _longitude;

    /**
     * Creates a new Location
     * @param lat  the latitude
     * @param longit  the longitude
     */
    public Location(double lat, double longit) {
        _latitude = lat;
        _longitude = longit;
    }

    /**
     *
     * @return  the latitude value
     */
    public double getLatitude() { return _latitude; }

    /**
     *
     * @return the longitude value
     */
    public double get_longitude() { return _longitude; }
}
