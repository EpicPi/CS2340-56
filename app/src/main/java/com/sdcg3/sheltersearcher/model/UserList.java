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
        for (User use : userList) {
            if (use != null && use.getName() != null) {
                if (use.getName().equals(user)) {
                    if (use.getPass().equals(pass)) {
                        current = use;
                        return true;
                    }
                }
            }
        }
        return false;

    }

}
