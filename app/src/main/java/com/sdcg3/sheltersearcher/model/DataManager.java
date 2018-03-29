package com.sdcg3.sheltersearcher.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aballari on 3/27/18.
 */

class DataManager {
    List<DataElement> theData;

    DataManager() {
        theData = new ArrayList<>();
        populateDataList();
    }

    private void populateDataList() {
        addReport(new DataElement("Coke Zero", "Sam's Deli", new Location(33.749, -84.388)));
        addReport(new DataElement("Pepsi", "Grandma Garage", new Location(33.8, -84.5)));
    }

    void addReport(DataElement de) {
        theData.add(de);
    }


    List<DataElement> getData() { return theData; }



}
