package com.sdcg3.sheltersearcher;

import android.app.Application;
import android.util.Log;

import com.opencsv.CSVReader;
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
    private User current = null;
    MyApp(){
        super();
        users.add(new User("user","pass"));

    }
    public void readCSV(){
        InputStream is = getResources().openRawResource(R.raw.csvfile);
        try{
            CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)));
            List<String[]> myEntries = reader.readAll();
            Log.d("some", myEntries.size()+"");
            Log.d("some", myEntries.get(0).length+"");
        }
        catch (Exception e){
            Log.d("stuff", e.toString());
        }
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