package com.sdcg3.sheltersearcher.model;

import java.util.List;

/**
 * Created by aballari on 3/27/18.
 */

public class DataServiceFacade {
    private static DataServiceFacade INSTANCE = new DataServiceFacade();
    public static DataServiceFacade getInstance() { return INSTANCE; }

    private DataManager theData = new DataManager();

    private DataElement theLastAddedElement;


    private DataServiceFacade() {

    }

    /**
     * get a list of all the data
     * @return  the full list of data
     */
    public List<DataElement> getData() { return theData.getData();}

    /**
     * Add a new data element to the model
     * @param name   the name of the element
     * @param desc   textual description of the element
     * @param loc    location of the element
     */
    public void addDataElement(String name, String desc, Location loc) {
        DataElement de = new DataElement(name, desc, loc);
        theData.addReport(de);
        theLastAddedElement = de;
    }

    /**
     * Return the last element added.  This method is mainly to support UI
     * @return the last element added to the model.
     */
    public DataElement getLastElementAdded() {
        return theLastAddedElement;
    }
}
