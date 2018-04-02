package com.sdcg3.sheltersearcher.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages data for the map view
 */

class DataManager {
    private final List<DataElement> theData = new ArrayList<>();
    private final List<Shelter> shelters;

    DataManager(List<Shelter> shelters) {
        this.shelters = shelters;
        populateDataList();
    }
    private void populateDataList() {
        for (Shelter shel: shelters) {
            addReport(new DataElement(shel.name,
                    "Phone Number: " + shel.phone + "\n" + "Address:  " +
                            shel.address + "\n" + "Information:  " + shel.notes,
                    new Location(Double.parseDouble(shel.latitude), Double.parseDouble(shel.longitude))));
        }
    }

    void addReport(DataElement de) {
        theData.add(de);
    }


    List<DataElement> getData() { return theData; }



}
