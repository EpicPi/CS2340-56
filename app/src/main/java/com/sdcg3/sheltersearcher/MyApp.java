package com.sdcg3.sheltersearcher;

import android.app.Application;
import android.content.Intent;
import android.support.v7.widget.SnapHelper;
import android.util.Log;

import com.opencsv.CSVReader;
import com.sdcg3.sheltersearcher.controllers.ShelterDetailActivity;
import com.sdcg3.sheltersearcher.model.Shelter;
import com.sdcg3.sheltersearcher.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pi on 3/4/18.
 */

public class MyApp extends Application {
    private List<User> users = new ArrayList<>();
    private List<Shelter> shelters = new ArrayList<>();
    private User current = null;
    private List<Shelter> filtered;
    private Shelter selected;

    MyApp() {
        super();
        users.add(new User("user", "pass"));
    }

    public void readCSV() {
        shelters.clear();
        InputStream is = getResources().openRawResource(R.raw.csvfile);
        try {
            CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)));
            List<String[]> myEntries = reader.readAll();
            for (String[] arr : myEntries) {
                shelters.add(new Shelter(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]));
            }
            shelters.remove(0);
        } catch (Exception e) {
            Log.d("stuff", e.toString());
        }

    }

    public void addUser(String user, String pass) {
        users.add(new User(user, pass));
    }

    public boolean isCorrect(String user, String pass) {
        if (user == null || pass == null)
            return false;
        List<User> curr = users.stream().filter((e) -> e.getUserName().equals(user)).collect(Collectors.toList());
        if (curr.size() > 0 && curr.get(0).checkPass(pass)) {
            current = curr.get(0);
            return true;
        }
        return false;
    }
    //use this from anywhere by saying ((MyApplication)getApplication()).addUser();

    public List<Shelter> getFiltered() {
        if (filtered != null)
            return filtered;
        return shelters;
    }

    public void resetFiltered() {
        filtered = null;
    }

    public Shelter getSelected() {
        return selected;
    }

    public void setSelected(Shelter selected) {
        this.selected = selected;
    }

    public void filter(String gender, String age, String name) {
        final String other = gender.equals("men")? "women":"LOLOLOLOL"; //capital letters dont exist cause we .toLowerCase everything

        filtered = shelters.stream().filter((el) -> {
            String restrictions = el.restrictions.toLowerCase();

            return restrictions.contains(gender) && !restrictions.contains(other) && restrictions.contains(age) && el.name.toLowerCase().contains(name);
        }).collect(Collectors.toList());
    }
}