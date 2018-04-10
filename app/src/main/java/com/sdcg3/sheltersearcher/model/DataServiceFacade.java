package com.sdcg3.sheltersearcher.model;

import com.google.android.gms.maps.GoogleMap;
import com.sdcg3.sheltersearcher.MyApp;

import java.util.List;

/**
 * Provides a data service facade
 */

public final class DataServiceFacade {
    private static final DataServiceFacade INSTANCE = new DataServiceFacade();

    /**
     *
     * @return instance
     */
    public static DataServiceFacade getInstance() { return INSTANCE; }


    private DataServiceFacade() {
    }

    /**
     * @return the data that is set
     * @param shelters shelters
     */
    public List<DataElement> setData(List<Shelter> shelters) {
        DataManager theData = new DataManager(shelters);
        return theData.getData();
    }

//    /**
//     * get a list of all the data
//     * @return  the full list of data
//     */
//    private List<DataElement> getData() { return theData.getData();}

//    /**
//     *  does stuff, obviously
//     * @param googleMap GoogleMap object
//     * @param app app data
//     */
//    public void doStuff(GoogleMap googleMap, MyApp app) {
//        List<Shelter> filteredAppResults = app.getFiltered();
//        setData(filteredAppResults);
//
//        //get the data to display
//        List<DataElement> dataList;
//        dataList = getData();
//    }


// --Commented out by Inspection START (4/4/18 10:02 PM):
//    /**
//     * Add a new data element to the model
//     * @param name   the name of the element
//     * @param desc   textual description of the element
//     * @param loc    location of the element
//     */
//    public void addDataElement(String name, String desc, Location loc) {
//        DataElement de = new DataElement(name, desc, loc);
//        theData.addReport(de);
//        theLastAddedElement = de;
//    }
// --Commented out by Inspection STOP (4/4/18 10:02 PM)

// --Commented out by Inspection START (4/4/18 10:02 PM):
//    /**
//     * Return the last element added.  This method is mainly to support UI
//     * @return the last element added to the model.
//     */
//    public DataElement getLastElementAdded() {
//        return theLastAddedElement;
//    }
// --Commented out by Inspection STOP (4/4/18 10:02 PM)
}
