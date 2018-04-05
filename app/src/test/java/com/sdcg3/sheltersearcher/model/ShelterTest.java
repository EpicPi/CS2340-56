package com.sdcg3.sheltersearcher.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by aballari on 4/5/18.
 * M10 - Akhila Ballari
 */
public class ShelterTest {
    List<Shelter> sheltersTest;
    Shelter shelter1;
    Shelter shelter2;
    @Before
    public void setUp() throws Exception {
        sheltersTest = new ArrayList<>();
        shelter1 = new Shelter("0", "My Sister's House", "264", "Women/Children",
                "-84.410142", "33.780174", "921 Howell Mill Road, Atlanta, Georgia 30318",
                "Temporary, Emergency, Residential Recovery", "(404) 367-2465", "0");
        shelter2 = new Shelter("0", "My Sister's House 2", "264", "Women/Children",
                "-84.410142", "33.780174", "921 Howell Mill Road, Atlanta, Georgia 30318",
                "Temporary, Emergency, Residential Recovery", "(404) 367-2465", "0");
        sheltersTest.add(shelter1);

    }

    @Test
    public void findByName() throws Exception {
        assertNull("Empty List Check Failed", Shelter.findByName(shelter1.getName(), new ArrayList<>()));
        assertSame("Shelter in List check failed", Shelter.findByName(shelter1.getName(), sheltersTest), shelter1);
        assertNull("Shelter not in list check faied", Shelter.findByName(shelter2.getName(), sheltersTest));
    }

}