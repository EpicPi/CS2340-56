package com.sdcg3.sheltersearcher.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jumshaid on 4/9/2018.
 */

public class UserList {

    public List<User> userList;

    public UserList() {
        userList = new ArrayList<>();
    }

    public void add(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public boolean isCorrectUser(String user, String pass, User current) {
        if (user == null || pass == null)
            return false;
        User user1 = new User(user, pass);
        if (userList.contains(user1)) {
            current = user1;
            return true;
        }
        return false;

    }

}
