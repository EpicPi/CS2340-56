package com.sdcg3.sheltersearcher.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages data for the map view
 */

class DataManager {
    private final List<DataElement> theData;
    private final List<Shelter> shelters;

    DataManager(List<Shelter> shelters) {
        this.theData = new ArrayList<>();
        this.shelters = new ArrayList<>();
        this.shelters.addAll(shelters);

        populateDataList();
    }
    private void populateDataList() {
        for (Shelter shel: shelters) {
            addReport(new DataElement(shel.getName(),
                    "Phone Number: " + shel.getPhone() + "\n" + "Address:  " +
                            shel.getAddress() + "\n" + "Information:  " + shel.getNotes(),
                    new Location(Double.parseDouble(shel.getLatitude()),
                            Double.parseDouble(shel.getLongitude()))));
        }
    }

    void addReport(DataElement de) {
        theData.add(de);
    }


    List<DataElement> getData() { return theData; }



}
