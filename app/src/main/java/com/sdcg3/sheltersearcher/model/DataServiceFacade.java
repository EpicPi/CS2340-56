package com.sdcg3.sheltersearcher.model;

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

    // --Commented out by Inspection (4/4/18 10:06 PM):private DataElement theLastAddedElement;


    private DataServiceFacade() {
    }

    /**
     *
     * @param shelters shelters
     */
    public List<DataElement> setData(List<Shelter> shelters) {
        DataManager theData = new DataManager(shelters);
        return theData.getData();
    }

// --Commented out by Inspection START (4/5/18 12:47 AM):
//    /**
//     * get a list of all the data
//     * @return  the full list of data
//     */
//    private List<DataElement> getData() { return theData.getData();}
// --Commented out by Inspection STOP (4/5/18 12:47 AM)


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
