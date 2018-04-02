package com.sdcg3.sheltersearcher.model;

/**
 * Models a location
 */

class Location {
    private final double _latitude;
    private final double _longitude;

    /**
     * Creates a new Location
     * @param latitude  the latitude
     * @param longitude  the longitude
     */
    public Location(double latitude, double longitude) {
        _latitude = latitude;
        _longitude = longitude;
    }

    /**
     * Returns lattitude
     * @return  the latitude value
     */
    public double getLatitude() { return _latitude; }

    /**
     * Returnd longitude
     * @return the longitude value
     */
    public double get_longitude() { return _longitude; }
}
