package com.sdcg3.sheltersearcher;

import android.app.Application;

import com.sdcg3.sheltersearcher.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pi on 3/4/18.
 */

public class MyApp extends Application {
    private List<User> users = new ArrayList<>();
    private User current = null;
    MyApp(){
        super();
        users.add(new User("user","pass"));
    }
    public void addUser(String user, String pass ) {
        users.add(new User(user,pass));
    }

    public boolean isCorrect(String user, String pass) {
        if(user == null || pass==null)
            return false;
        List<User> curr= users.stream().filter((e) -> e.getUserName().equals(user)).collect(Collectors.toList());
        if(curr.size()>0 && curr.get(0).checkPass(pass)){
            current = curr.get(0);
            return true;
        }
        return false;
    }
    //use this from anywhere by saying ((MyApplication)getApplication()).addUser();
}