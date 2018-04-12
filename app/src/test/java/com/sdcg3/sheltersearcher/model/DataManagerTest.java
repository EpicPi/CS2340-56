package com.sdcg3.sheltersearcher.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Destin on 4/9/18.
 * JUNIT test for populateDataList() in DataManager (accessed via the DataManager constructor)
 *
 * @author Destin Winata
 */

public class DataManagerTest {
    DataManager dataManager;
    DataManager nullCheck;
    DataManager expected;

    @Before
    public void setUp() throws Exception {
        List<Shelter> shelters = new ArrayList<>();
        shelters.add(new Shelter("1", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
        shelters.add(new Shelter("2", "2", "2", "2", "2", "2", "2", "2", "2", "2"));
        shelters.add(new Shelter("3", "3", "3", "3", "3", "3", "3", "3", "3", "3"));
        dataManager = new DataManager(shelters);
    }

    @Test
    public void populateDataListBranchTest() throws Exception {
        nullCheck = new DataManager(null);
        assertEquals("Method does not handle null shelters", new ArrayList<Shelter>(), nullCheck.getShelters());
        assertEquals("Method does not handle null shelters", new ArrayList<DataElement>(), nullCheck.getData());

        List<Shelter> shelters = new ArrayList<>();
        shelters.add(new Shelter("1", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
        shelters.add(null);
        shelters.add(new Shelter("2", "2", "2", "2", "2", "2", "2", "2", "2", "2"));
        shelters.add(null);
        shelters.add(new Shelter("3", "3", "3", "3", "3", "3", "3", "3", "3", "3"));
        expected = new DataManager(shelters);

        // Check null
        assertEquals(expected.getData().size(), dataManager.getData().size());
        assertTrue(dataManager.getData().get(0).getName().equals(expected.getData().get(0).getName()));
        assertTrue(dataManager.getData().get(1).getName().equals(expected.getData().get(1).getName()));
        assertFalse(dataManager.getData().get(0).getName().equals(expected.getData().get(1).getName()));
    }
}
