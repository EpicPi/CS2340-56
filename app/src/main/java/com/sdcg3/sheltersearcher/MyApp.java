package com.sdcg3.sheltersearcher;

import android.app.Application;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pi on 2/19/18.
 */

public class MyApp extends Application {
    private Map<String, String> users =new HashMap<String, String>();

    public void addUser(String user, String pass ) {
        users.put(user,pass);
    }

    public boolean isCorrect(String user, String pass) {
        return users.get(user).equals(pass);
    }
} 