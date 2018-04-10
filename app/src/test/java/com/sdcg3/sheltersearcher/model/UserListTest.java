package com.sdcg3.sheltersearcher.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Destin on 4/9/18.
 * Just realized Jumshaid was doing this JUnit. FML
 *
 * @author Destin Winata
 */

public class UserListTest {
    UserList u;

    @Before
    public void setUp() throws Exception {
        u = new UserList();
        u.add(new User("Stupid", "Idiot"));
        u.add(new User("Jeff", "comedy"));
    }

    @Test
    public void isCorrectUserBranchTest() {
        User temp = new User("Fake User", "Fake Password");

        u.add(null);
        u.add(new User(null, "lol"));
        assertFalse("Method does not handle null User objects", u.isCorrectUser("Just testing", "for null handling", temp));
        assertEquals("Method does not correctly assign current User", "Fake User", temp.getName());

        assertFalse("Method does not handle null values for user and pass Strings", u.isCorrectUser(null, null, temp));
        assertEquals("Method does not correctly assign current User", "Fake User", temp.getName());

        assertFalse("Method incorrectly matches password", u.isCorrectUser("Wrong Username", "Wrong Password", temp));
        assertEquals("Method does not correctly assign current User", "Fake User", temp.getName());

        assertFalse("Method incorrectly matches password", u.isCorrectUser("Stupid", "Wrong Password", temp));
        assertEquals("Method does not correctly assign current User", "Fake User", temp.getName());

        assertFalse("Method incorrectly matches password", u.isCorrectUser("Wrong Username", "Idiot", temp));
        assertEquals("Method does not correctly assign current User", "Fake User", temp.getName());

        assertTrue("Method does not match existing user", u.isCorrectUser("Stupid", "Idiot", temp));

        assertTrue("Method does not match existing user", u.isCorrectUser("Jeff", "comedy", temp));
    }
}
