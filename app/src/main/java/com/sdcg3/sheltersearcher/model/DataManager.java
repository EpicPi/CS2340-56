package com.sdcg3.sheltersearcher.model;

import com.sdcg3.sheltersearcher.MyApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aballari on 3/27/18.
 */

class DataManager {
    List<DataElement> theData = new ArrayList<>();
    List<Shelter> shelters;

    DataManager(List<Shelter> shelters) {
        this.shelters = shelters;
        populateDataList();
    }

    private void populateDataList() {
        for (Shelter shel: shelters) {
            addReport(new DataElement(shel.name,
                    "Phone Number: " + shel.phone + "\n" + "Address:  " + shel.address + "\n" + "Information:  " + shel.notes,
                    new Location(Double.parseDouble(shel.lati), Double.parseDouble(shel.longi))));
        }
//        addReport(new DataElement("Coke Zero", "Sam's Deli", new Location(33.749, -84.388)));
//        addReport(new DataElement("Pepsi", "Grandma Garage", new Location(33.8, -84.5)));
    }

    void addReport(DataElement de) {
        theData.add(de);
    }


    List<DataElement> getData() { return theData; }



}
