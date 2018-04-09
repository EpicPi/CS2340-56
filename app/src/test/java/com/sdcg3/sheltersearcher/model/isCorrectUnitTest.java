package com.sdcg3.sheltersearcher.model;

import com.sdcg3.sheltersearcher.MyApp;

import org.junit.Before;
import org.junit.Test;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * M10 - Jumshaid Yamin
 */
public class isCorrectUnitTest {
    UserList userList;
    User user1;
    User user2;
    User user3;
    User user4;
    User userX;

    @Before
    public void setUp() {
        userList = new UserList();
        user1 = new User("Bob Waters", "cs2340");
        user2 = new User("George P Burdell", "gatech");
        user3 = new User(null, "THWg");
        user4 = new User("Bud Peterson", null);
        userX = new User("x","y");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

    }

    @Test
    public void isCorrectUser()  {
        assertFalse("Null username failed", userList.isCorrectUser(null, "THWg", userX));
        assertFalse("Null password failed", userList.isCorrectUser("Bud Peterson", null, null));

        assertTrue("Cannot find \"Bob Waters\", \"cs2340\" ", userList.isCorrectUser("Bob Waters", "cs2340", userX));
        assertTrue("Cannot find \"George P Burdell\", \"gatech\" ", userList.isCorrectUser("George P Burdell", "gatech", userX));

        assertFalse("No such username and pass: \"Pi Kanch\", \"fool\" ", userList.isCorrectUser("Pi Kanch", "fool", userX));
        assertFalse("No such username and pass: \"Destin W\", \"student\" ", userList.isCorrectUser("Destin W", "student", userX));

    }

}