package com.sdcg3.sheltersearcher.model;

import android.app.Application;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pi on 2/19/18.
 */

public class Users extends Application {
    private Map<String, String> users = new HashMap<>();

    Users(){
        super();
        users.put("user","pass");
    }
    public void addUser(String user, String pass ) {
        users.put(user,pass);
    }

    public boolean isCorrect(String user, String pass) {
        if(user == null || pass==null)
            return false;
        if(!users.containsKey(user))
            return false;
        return users.get(user).equals(pass);
    }
    //use this from anywhere by saying ((MyApplication)getApplication()).addUser();
}