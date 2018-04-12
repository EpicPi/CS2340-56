package com.sdcg3.sheltersearcher.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit Test for findByNumber() method in User
 *
 * @author Piyush Kancharlawar
 */
public class UserTest {
    List<User> users;
    User u1;
    User u2;
    User u3;
    User u4;

    @Before
    public void setUp() throws Exception {
        users = new ArrayList<>();
        u1 = new User("Professor Waters", "12345", null, "1");
        u2 = new User("Piyush", "sdcg3", null, "2");
        u3 = new User("Some Idiot", "lol", null, "notavalidnumber");
        u4 = new User("Some Other Idiot", "lolpart2", null, null);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
    }

    @Test
    public void invalidNumberFormatTest() throws Exception {
        assertEquals("User does not handle invalid number formats",0, u3.getNumber());
        assertNotNull("User does not handle null number inputs", u4.getNumber());
    }

    @Test
    public void findByNumberBranchTest() throws Exception {
        assertNull("Does not return null on a null list", User.findByNumber(1, null));
        assertNull("Does not return null on empty list", User.findByNumber(2, new ArrayList<User>()));
        assertFalse("Erroneously returns true on un-matching users", User.findByNumber(1, users).equals(u2));
        assertTrue("Erroneously returns false on matching users", User.findByNumber(2, users).equals(u2));
    }
}